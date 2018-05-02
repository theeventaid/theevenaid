package com.tgj.eventaid.controllers;

import com.tgj.eventaid.models.Event;
import com.tgj.eventaid.repositories.EventsRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventsController {

    public EventsRepository eventsRepository;

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/events/create")
    public String getCreateForm(Model model){
        return "/events/create";
    }

    @PostMapping("/events/create")
    public String saveEvent(@ModelAttribute Event event){
        System.out.println(event.getName());
        eventsRepository.save(event);
        return "/";
    }
}
