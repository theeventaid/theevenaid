package com.tgj.eventaid.controllers;

import com.tgj.eventaid.models.Event;
import com.tgj.eventaid.repositories.EventsRepository;
import org.apache.catalina.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class EventsController {

    public EventsRepository eventsRepository;

    public EventsController (EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/events/create")
    public String getCreateForm(Model model){
        model.addAttribute("event", new Event());
        return "/events/create";
    }

    @PostMapping("/events/create")
    public String saveEvent(@ModelAttribute Event event){

//        System.out.println(event.getStart_date());
//        System.out.println(event.getEnd_date());
//        event.setStart_date(start_date);
//        event.setEnd_date(end_date);
        System.out.println("event.getId() = " + event.getId());
        event.setUser((com.tgj.eventaid.models.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        eventsRepository.save(event);
        return "redirect:/";
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
