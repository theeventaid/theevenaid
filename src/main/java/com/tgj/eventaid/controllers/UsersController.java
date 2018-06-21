package com.tgj.eventaid.controllers;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tgj.eventaid.models.Event;
import com.tgj.eventaid.models.User;
import com.tgj.eventaid.repositories.ArtistsRepository;
import com.tgj.eventaid.repositories.EventsRepository;
import com.tgj.eventaid.repositories.TicketsRepository;
import com.tgj.eventaid.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class UsersController {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private EventsRepository eventsRepository;
	private TicketsRepository ticketsRepository;
	private ArtistsRepository artistsRepository;

	@Autowired
	public UsersController(UserRepository userRepository, PasswordEncoder passwordEncoder, ArtistsRepository artistsRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.eventsRepository = eventsRepository;
		this.artistsRepository = artistsRepository;
	}

	@GetMapping("/")
	public String validLogin(@RequestHeader("Host") String host, Model model) {
		model.addAttribute("host", host);
		return "index";
	}

	@GetMapping("/register")
	public String showSignupForm(Model model) {
		model.addAttribute("user", new User());
		return "/users/register";
	}

	@GetMapping("/profile")
	public String showProfile(@ModelAttribute User user, Model model) {
		model.addAttribute("user", userRepository.findByEmail(user.getEmail()));
//		Trying to get number of tickets sold.
//		List<Event> events = user.getEvents();
//		for (Event event : events){
//		    model.addAttribute("sold", ticketsRepository.countByEvent_id((int)event.getId()));
//		}
		return "users/profile";
	}

	@GetMapping("/reset-password")
	public String resetPassword() {
		return "users/reset_password";
	}

	@PostMapping("/reset-password")
	public String setNewPassword(@RequestParam(name = "email") String email,
								 @RequestParam(name = "newPassword") String newPassword,
								 @RequestParam(name = "newPasswordConfirm") String passwordConfirm) {

		User existingUser = userRepository.findByEmail(email);
		existingUser.setPassword(passwordEncoder.encode(newPassword));
		userRepository.save(existingUser);
		return "redirect:/ ";
	}

	@GetMapping("/about")
	public String aboutPage() {
		return "about";
	}
}