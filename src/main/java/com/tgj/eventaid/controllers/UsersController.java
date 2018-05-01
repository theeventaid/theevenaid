package com.tgj.eventaid.controllers;

import com.tgj.eventaid.models.Users;
import com.tgj.eventaid.Repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsersController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showSignupForm (Model model){
//        model.addAttribute("user", new Users());
        model.addAttribute("user", "test");
        return "/register";
    }

    @PostMapping("/register")
    public String saveUser (@ModelAttribute Users user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
//        saveUser(user);
        userRepository.save(user);
        return "redirect:/index";
    }

    @GetMapping("/logout")
    public String logout(){
        return "index";
    }

}

