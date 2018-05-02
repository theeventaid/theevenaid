package com.tgj.eventaid.controllers;

import com.tgj.eventaid.repositories.TicketsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
