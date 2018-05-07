package com.tgj.eventaid.controllers;

import com.tgj.eventaid.models.Event;
import com.tgj.eventaid.repositories.EventsRepository;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventsController {

    public EventsRepository eventsRepository;

    public EventsController(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/events")
    public String getAll(Model model) {
        Iterable<Event> events = eventsRepository.findAll();
        model.addAttribute("events", events);
        return "events/all";
    }

    @PostMapping("/search")
    public String searchEvents(@RequestParam String query, Model model) {
        Iterable<Event> events = eventsRepository.findAllLikeName(query);
        model.addAttribute("events", events);
        return "events/all";
    }

    @GetMapping("/events/{id}")
    public String getEvent(@PathVariable Long id, Model model) {
        Event event = eventsRepository.findOne(id);
        model.addAttribute("event", event);
        return "events/index";
    }

    @GetMapping("/events/create")
    public String getCreateForm(Model model) {
        model.addAttribute("event", new Event());
        return "/events/create";
    }

    @PostMapping("/events/create")
    public String saveEvent(@ModelAttribute Event event, @RequestParam ("upload") String picture){
        event.setMedia_location(picture);
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

    @GetMapping("/upload")
    public String upload() {
        return "users/upload";
    }

    @PostMapping("/upload")
    public String uploadFile(@ModelAttribute Event event) {
        return "/";
    }
}
