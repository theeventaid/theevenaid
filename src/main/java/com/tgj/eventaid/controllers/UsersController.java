package com.tgj.eventaid.controllers;

import com.tgj.eventaid.models.Artist;
import com.tgj.eventaid.models.Event;
import com.tgj.eventaid.models.User;
import com.tgj.eventaid.repositories.ArtistsRepository;
import com.tgj.eventaid.repositories.EventsRepository;
import com.tgj.eventaid.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import org.springframework.web.bind.annotation.*;
import retrofit2.http.HEAD;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class UsersController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private EventsRepository eventsRepository;
    private ArtistsRepository artistsRepository;

    @ModelAttribute("user")
    public User newUser() {
        return new User();
    }

    @Autowired
    public UsersController(UserRepository userRepository, PasswordEncoder passwordEncoder, ArtistsRepository artistsRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.eventsRepository =eventsRepository;
        this.artistsRepository = artistsRepository;
    }

    @GetMapping("/")
    public String validLogin(@RequestHeader("Host") String host, Model model){
        model.addAttribute("host", host);
        return "index";
    }

    @GetMapping("/register")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "/users/register";
    }

    //  Registering now is executed in the Recaptcha Controller
//    @PostMapping("/register")
//    public String saveUser(@ModelAttribute User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setCreated_on(LocalDateTime.now());
//        userRepository.save(user);
//        return "redirect:/";
//    }

    @GetMapping("/profile")
    public String showProfile(Model model){

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user == null)
            return "redirect:/";
        model.addAttribute("user", userRepository.findByEmail(user.getEmail()));
        return "users/profile";
    }

    @GetMapping("/reset-password")
    public String resetPassword(Model model) {
        System.out.println("get here");
        User user = new User();
        model.addAttribute("user", user);
        return "/users/reset_password";
    }

    @PostMapping("/reset-password")
    public String setNewPassword(@RequestParam(name = "email", required = false) String email,
                                 @RequestParam(name= "password", required = false) String newPassword,
                                 @RequestParam(name= "newPasswordConfirm") String passwordConfirm) {

        System.out.println("get here too");
        System.out.println(email);
        System.out.println(newPassword); // not getting this
        System.out.println(passwordConfirm);
        User existingUser = userRepository.findByEmail(email);
        System.out.println(existingUser.getFirstname());

//        if(!passwordConfirm.equals(user.getPassword())) {
//            errors.rejectValue("password", "user.password", "Your passwords must match");
//        }
//
//        if(errors.hasErrors()) {
//            model.addAttribute("errors", errors);
//            model.addAttribute("user", user);
//            return "users/reset_password";
//        }

        existingUser.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(existingUser);
        return "redirect:/ ";
    }
}

