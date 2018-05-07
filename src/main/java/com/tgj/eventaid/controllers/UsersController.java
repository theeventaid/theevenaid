package com.tgj.eventaid.controllers;

import com.tgj.eventaid.models.Budget;
import com.tgj.eventaid.models.Event;
import com.tgj.eventaid.models.User;
import com.tgj.eventaid.repositories.BudgetRepository;
import com.tgj.eventaid.repositories.EventsRepository;
import com.tgj.eventaid.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Arrays;

@Controller
public class UsersController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private EventsRepository eventsRepository;
    private BudgetRepository budgetRepository;

    @Autowired
    public UsersController(UserRepository userRepository, PasswordEncoder passwordEncoder, BudgetRepository budgetRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.eventsRepository =eventsRepository;
        this.budgetRepository = budgetRepository;
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
        User user = userRepository.findOne(id);
        DecimalFormat dFormat = new DecimalFormat("####,###,###.00");
        Budget budget = budgetRepository.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("event_budget", dFormat.format(budget.getEvent_budget()));
        model.addAttribute("target_spending", dFormat.format(budget.getTarget_spending()));
        model.addAttribute("target_profit", dFormat.format(budget.getTarget_profit()));
//        model.addAttribute("budget", budget);
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

