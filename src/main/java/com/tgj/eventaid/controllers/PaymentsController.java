package com.tgj.eventaid.controllers;

import com.tgj.eventaid.models.Event;
import com.tgj.eventaid.models.User;
import com.tgj.eventaid.repositories.*;
import com.tgj.eventaid.models.ChargeRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentsController {
    public EventsRepository eventsRepository;

    // Stripe info will be here
    public PaymentsController(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @GetMapping("/purchase")
    public String purchase(){
        return "events/tickets/purchase";
    }

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @GetMapping("checkout/event/{id}")
    public String checkout(@PathVariable Long id, Model model) {
        Event event = eventsRepository.findOne(id);
        model.addAttribute("event", event);
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.USD);
        return "events/tickets/checkout";
    }


}
