package com.tgj.eventaid.controllers;

import com.tgj.eventaid.models.*;
import com.tgj.eventaid.repositories.*;
import com.tgj.eventaid.utilities.DomainUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
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

    public EventsController(EventsRepository eventsRepository, UserRepository userRepository, ArtistsRepository artistsRepository, VenueRepository venueRepository) {
        this.eventsRepository = eventsRepository;
        this.userRepository = userRepository;
        this.artistsRepository = artistsRepository;
        this.venueRepository = venueRepository;
    }

    @ModelAttribute("user")
    public User newUser() {
        return new User();
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
//        event.setVenue_id(new Venue()); // TODO Only A Temporary Fix
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
                            @RequestParam("artist_name") String artist_name,
                            @RequestParam("artist_cost") BigDecimal artist_cost,
                            @RequestParam("fileUpload") String fileUpload,
                            @RequestParam("artist_note") String artist_note,
                            @RequestParam("venue_address") String venue_address,
                            @RequestParam("venue_cost") BigDecimal venue_cost,
                            @RequestParam("contract_yes") Boolean contract_yes,
                            @RequestParam("venue_Upload") String venue_upload
    )
    {
//        saving info to events table
        Venue venue = new Venue();
        venue.setAddress(venue_address);
        venue.setCosts(venue_cost);
        venue.setContract(contract_yes);
        venue.setContract_location(venue_upload);
        venueRepository.save(venue);

        event.setVenue_id(venue);
        event.setMedia_location(picture);
        User authdUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findById(authdUser.getId());
        event.setUser(user);
        event.setOwner(user);

        eventsRepository.save(event);

        //saving info to artists table
        Artist artist = new Artist();
        artist.setEvent(event);
        artist.setName(artist_name);
        artist.setCosts(artist_cost);
        artist.setContract_location(fileUpload);
        artist.setNotes(artist_note);
        artistsRepository.save(artist);

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
