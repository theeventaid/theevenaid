package com.tgj.eventaid.controllers;

import com.tgj.eventaid.models.Event;
import com.tgj.eventaid.models.User;
import com.tgj.eventaid.repositories.EventsRepository;
import com.tgj.eventaid.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.Arrays;

@Controller
public class UsersController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private EventsRepository eventsRepository;

    @Autowired
    public UsersController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.eventsRepository =eventsRepository;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "/users/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreated_on(LocalDateTime.now());


        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/profile/{id}")
    public String showProfile(@PathVariable Long id, Model model){
        System.out.println("get here");
        User user = userRepository.findOne(id);
        System.out.println(user);
        model.addAttribute("user", user);
        return "users/profile";
    }
}

