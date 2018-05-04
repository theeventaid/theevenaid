package com.tgj.eventaid.controllers;

import com.tgj.eventaid.models.Event;
import com.tgj.eventaid.repositories.EventsRepository;
import org.apache.catalina.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
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
    public String saveEvent(@ModelAttribute Event event, @RequestParam ("upload") String picture){
        event.setMedia_location(picture);
        System.out.println(event.getStart_date());
        System.out.println(event.getEnd_date());
        System.out.println(event.getMedia_location());
        System.out.println("event.getId() = " + event.getId());

        eventsRepository.save(event);
        return "redirect:/";
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/upload")
    public String upload() {
        return "users/upload";
    }

    @PostMapping("/upload")
    public String uploadFile(@ModelAttribute Event event) {

        return "/";
    }



}
