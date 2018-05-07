package com.tgj.eventaid.controllers;

import com.tgj.eventaid.models.Budget;
import com.tgj.eventaid.models.Event;
import com.tgj.eventaid.models.User;
import com.tgj.eventaid.repositories.BudgetRepository;
import com.tgj.eventaid.repositories.EventsRepository;
import com.tgj.eventaid.repositories.UserRepository;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventsController {

    public EventsRepository eventsRepository;
    public BudgetRepository budgetRepository;
    public UserRepository userRepository;

    public EventsController(EventsRepository eventsRepository, BudgetRepository budgetRepository, UserRepository userRepository) {
        this.eventsRepository = eventsRepository;
        this.budgetRepository = budgetRepository;
        this.userRepository = userRepository;
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
    public String saveEvent(@ModelAttribute Event event,
                            @RequestParam ("upload") String picture,
                            @ModelAttribute Budget budget,
                            @RequestParam ("event_budget") BigDecimal event_budget,
                            @RequestParam ("target_profit") BigDecimal target_profit,
                            @RequestParam ("target_spending") BigDecimal target_spending){
        event.setMedia_location(picture);
        User authdUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findById(authdUser.getId());
        event.setUser(user);
        event.setOwner(user);
        eventsRepository.save(event);
        //saving info to budget tables
        budget.setEvent(event);
        budget.setEvent_budget(event_budget);
        budget.setTarget_profit(target_profit);
        budget.setTarget_spending(target_spending);
        budgetRepository.save(budget);

        return "redirect:/events";
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
