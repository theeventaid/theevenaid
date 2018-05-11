package com.tgj.eventaid.controllers;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.tgj.eventaid.models.ChargeRequest;
import com.tgj.eventaid.models.Event;
import com.tgj.eventaid.services.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.tgj.eventaid.models.*;
import com.tgj.eventaid.repositories.*;
import java.sql.Timestamp;

@Controller
public class ChargeController {

    public EventsRepository eventsRepository;
    public UserRepository userRepository;
    public TicketsRepository ticketsRepository;

    @Autowired
    private StripeService paymentsService;

    public ChargeController(EventsRepository eventsRepository, TicketsRepository ticketsRepository, UserRepository userRepository){
        this.userRepository = userRepository;
        this.eventsRepository = eventsRepository;
        this.ticketsRepository = ticketsRepository;
    }

    @ModelAttribute("user")
    public User newUser() {
        return new User();
    }

    @PostMapping("/charge/event/{id}")
    public String charge(@PathVariable Long id, ChargeRequest chargeRequest, Model model)
            throws StripeException {
        Event event = eventsRepository.findOne(id);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        chargeRequest.setDescription(event.getDescription());
        chargeRequest.setCurrency(ChargeRequest.Currency.USD);
        Charge charge = paymentsService.charge(chargeRequest);
        Ticket ticket = new Ticket();
        ticket.setEvent_id(event);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ticket.setUser_id(userRepository.findById(user.getId()));
        ticket.setCharge_id(charge.getId());
        ticket.setCharge_status(charge.getStatus());
        ticket.setBalance_transaction_id(charge.getBalanceTransaction());
        ticket.setPurchased_on(timestamp);
        ticketsRepository.save(ticket);

        event.setTickets_available(event.getTickets_available() - 1);
        eventsRepository.save(event);
        model.addAttribute("ticket", ticket);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "events/tickets/confirmation";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "events/tickets/confirmation";
    }
}
