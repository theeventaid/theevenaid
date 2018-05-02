package com.tgj.eventaid.controllers;


import com.tgj.eventaid.models.User;
import com.tgj.eventaid.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class UsersController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UsersController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "/register";
    }

        @PostMapping("/register")
        public String saveUser (@ModelAttribute User user){
            System.out.println("Get Here");
            System.out.println(user.getEmail());
            System.out.println(user.getTelephone());
//            String hash = passwordEncoder.encode(user.getPassword());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setCreated_on(LocalDateTime.now());
            System.out.println(user.getPassword());
//        saveUser(user);
            System.out.println(user);
        userRepository.save(user);
            return "redirect:/index";
        }

        @GetMapping("/index")
        public String showIndexPage () {
        return "/index";
        }
    }

