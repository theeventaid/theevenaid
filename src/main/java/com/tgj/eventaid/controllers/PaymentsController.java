package com.tgj.eventaid.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class PaymentsController {

    @GetMapping("/purchase")
    public String index(Model model) {
        model.addAttribute("ads", ticketsDao.findAll());
        return "/ads/index";
    }

}
