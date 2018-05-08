package com.tgj.eventaid.models;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.soap.Text;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message = "Must have Event Name")
    @Size(min = 3, message = "An Event Name must be at least 3 characters.")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Must have Start Date")
    @Column(nullable = false)
    private Date start_date;

    @NotBlank(message = "Must have End Date")
    @Column(nullable = false)
    private Date end_date;

    @NotBlank(message = "Must have Location for Event")
    @Size(min = 10, message = "A location must be at least 10 characters.")
    @Column(nullable = false)
    private String location;

    @NotBlank(message = "Must have Description")
    @Column(nullable = false)
    private String description;

    @NotBlank(message = "Must have Ticket Amount")
    @Column(nullable = false)
    private int tickets_available;

    @Column(nullable = false)
    private String media_location;

    @NotBlank(message = "Must have Url for Event")
    @Size(min = 3, message = "A url must be at least 3 characters.")
    @Column(nullable = false)
    private String url;

    @OneToOne  // relationship to events.id
    @JoinColumn(name = "venue_id")
    private Venue venue_id;

    @ManyToOne
    private User user;

    // id must be in relationship to the users_events pivot table, and event_id on event_tickets
    @ManyToMany
    @JoinTable(
            name = "users_events",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public Event() {}

    public Event(long id, String name, Date start_date, Date end_date, String location, String url, Venue venue_id, String media_location, int tickets_available, String description) {
        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.location = location;
        this.url = url;
        this.venue_id = venue_id;
        this.media_location = media_location;
        this.tickets_available = tickets_available;
        this.description = description;
    }

    // insert new event
    public Event(String name, Date start_date, Date end_date, String location, String url, Venue venue_id, String media_location, int tickets_available, String description) {
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.location = location;
        this.url = url;
        this.venue_id = venue_id;
        this.media_location = media_location;
        this.tickets_available = tickets_available;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTickets_available() {
        return tickets_available;
    }

    public void setTickets_available(int tickets_available) {
        this.tickets_available = tickets_available;
    }

    public String getMedia_location() {
        return media_location;
    }

    public void setMedia_location(String media_location) {
        this.media_location = media_location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Venue getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(Venue venue_id) {
        this.venue_id = venue_id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
