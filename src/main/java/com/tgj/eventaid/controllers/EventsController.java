package com.tgj.eventaid.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tgj.eventaid.models.*;
import com.tgj.eventaid.repositories.*;
import com.tgj.eventaid.utilities.DomainUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.tgj.eventaid.models.ChargeRequest;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventsController {

	public EventsRepository eventsRepository;
	public UserRepository userRepository;
	public ArtistsRepository artistsRepository;
	public VenueRepository venueRepository;
	public TicketsRepository ticketsRepository;

	public EventsController(EventsRepository eventsRepository, UserRepository userRepository, ArtistsRepository artistsRepository, VenueRepository venueRepository) {
		this.eventsRepository = eventsRepository;
		this.userRepository = userRepository;
		this.artistsRepository = artistsRepository;
		this.venueRepository = venueRepository;
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

	@Value("${STRIPE_PUBLIC_KEY}")
	private String stripePublicKey;

	@GetMapping("/events/{id}")
	public String getEvent(@PathVariable Long id, Model model) {
		Event event = eventsRepository.findOne(id);
		model.addAttribute("event", event);

//		Stripe info
		model.addAttribute("stripePublicKey", stripePublicKey);
		model.addAttribute("currency", ChargeRequest.Currency.USD);

		return "events/index";
	}

	//	Mapping modal information for tickets
	@GetMapping("/findticket")
	@ResponseBody
	public Ticket findticket(long id) {
		System.out.println("This is the ID being passed: " + id);
		return ticketsRepository.findById(id);
	}


	@GetMapping("/events/create")
	public String getCreateForm(Model model) {
		model.addAttribute("event", new Event());
		return "events/create";
	}

	@PostMapping("/events/create")
	public String saveEvent(@ModelAttribute Event event,
							@ModelAttribute User user,
							@RequestParam(value = "upload", required = false) String picture
	) {

		if (picture != null)
			event.setMedia_location(picture);

		event.setOwner(user);
		// This should fix the problem with the user
		event.setUser(user);
		eventsRepository.save(event);

		return "redirect:/events/" + event.getId();
	}

	@GetMapping("/events/edit/{id}")
	public String editEventPage(@PathVariable Long id, Model model) {
		Event event = eventsRepository.findOne(id);
		model.addAttribute("event", event);
		return "events/edit";
	}

	@PostMapping("/events/edit")
	public String updateEvent(@ModelAttribute Event event,
							  @RequestParam(value = "upload", required = false) String picture) {

		if(picture != null)
			event.setMedia_location(picture);

		eventsRepository.save(event);
		return "redirect:/events/" + event.getId();
	}

	@PostMapping("/events/delete/{id}")
	public String deleteEvent(@PathVariable Long id) {
		eventsRepository.delete(id);
		return "redirect:/profile";
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
