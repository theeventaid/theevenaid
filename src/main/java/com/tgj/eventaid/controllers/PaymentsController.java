package com.tgj.eventaid.controllers;

import com.tgj.eventaid.models.Event;
import com.tgj.eventaid.repositories.TicketsRepository;
import com.tgj.eventaid.models.ChargeRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentsController {

    private TicketsRepository ticketsDao;

//    @GetMapping("/purchase")
//    public String index(Model model) {
//        model.addAttribute("tickets", ticketsDao.findAll());
//        return "/events/tickets/purchase";
//    }

    // Stripe info will be here

    @GetMapping("/purchase")
    public String purchase(){
        return "events/tickets/purchase";
    }

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @RequestMapping("/checkout")
    public String checkout(@ModelAttribute Event event, Model model) {
        System.out.println(event.getName());
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.USD);
        return "events/tickets/checkout";
    }


}
