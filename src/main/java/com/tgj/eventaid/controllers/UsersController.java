package com.tgj.eventaid.controllers;

import com.tgj.eventaid.models.Artist;
import com.tgj.eventaid.models.Budget;
import com.tgj.eventaid.models.Event;
import com.tgj.eventaid.models.User;
import com.tgj.eventaid.repositories.ArtistsRepository;
import com.tgj.eventaid.repositories.BudgetRepository;
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

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Arrays;

@Controller
public class UsersController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private BudgetRepository budgetRepository;
    private ArtistsRepository artistsRepository;

    @Autowired
    public UsersController(UserRepository userRepository, PasswordEncoder passwordEncoder, BudgetRepository budgetRepository, ArtistsRepository artistsRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.budgetRepository = budgetRepository;
        this.artistsRepository = artistsRepository;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "/users/register";
    }

    @PostMapping("/register")
    public String saveUser( @Valid  Errors validation, Model model, @ModelAttribute User user) {
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreated_on(LocalDateTime.now());


        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String showProfile(Model model){

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user == null)
            return "redirect:/";

        model.addAttribute("user", userRepository.findByEmail(user.getEmail()));
//        DecimalFormat dFormat = new DecimalFormat("####,###,###.00");
//        Budget budget = budgetRepository.findOne(user.getId());
//        Artist artist = artistsRepository.findOne(user.getId());
//        model.addAttribute("event_budget", dFormat.format(budget.getEvent_budget()));
//        model.addAttribute("target_spending", dFormat.format(budget.getTarget_spending()));
//        model.addAttribute("target_profit", dFormat.format(budget.getTarget_profit()));
//        model.addAttribute("artist_name", artist.getName());
//        model.addAttribute("artist_cost", dFormat.format(artist.getCosts()));
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

