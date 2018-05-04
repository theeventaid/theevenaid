package com.tgj.eventaid.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String telephone;

    @Column
    private LocalDateTime created_on;

    @Column(nullable = false)
    private boolean owner;

    @OneToMany (mappedBy = "user_id") // users can get many tickets, many tickets can be owned by one user. mapped by parameter name "user" (see Ticket class)
    private List<Ticket> eventTickets;

    @OneToMany(mappedBy = "user")
    private List<Event> events;

//    @ManyToMany (mappedBy = "event_id")
//    private List<Event> event_id;

    public User() {}
//
    // Security Config
    public User(User copy) {
        id = copy.id;
        firstname = copy.firstname;
        lastname = copy.lastname;
        address = copy.address;
        email = copy.email;
        password = copy.password;
        telephone = copy.telephone;
        created_on = copy.created_on;
        owner = copy.owner;
        eventTickets = copy.eventTickets;
        events = copy.events;
    }
//    public User(String firstname, String lastname,String email, String password, String telephone) {
//        this.firstname =firstname;
//        this.lastname = lastname;
//        this.email = email;
//        this.password =password;
//        this.telephone =telephone;
//    }
//
//    // This is useful to insert users
//    public User(String firstname, String lastname, String address, String email, String password, String telephone, LocalDateTime created_on, boolean owner) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.address = address;
//        this.email = email;
//        this.password = password;
//        this.telephone = telephone;
//        this.created_on = created_on;
//        this.owner = owner;
//    }
//
//    // This is useful to get a full user obj
//    public User(long id, String firstname, String lastname, String address, String email, String password, String telephone, LocalDateTime created_on, boolean owner) {
//        this.id = id;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.address = address;
//        this.email = email;
//        this.password = password;
//        this.telephone = telephone;
//        this.created_on = created_on;
//        this.owner = owner;
//    }

//    public User(User copy) {
//        this.id = copy.id;
//        this.firstname = copy.firstname;
//        this.lastname = copy.lastname;
//        this.address = copy.address;
//        this.email = copy.email;
//        this.password = copy.password;
//        this.telephone = copy.telephone;
//        this.created_on = copy.created_on;
//        this.owner = copy.owner;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public LocalDateTime getCreated_on() {
        return created_on;
    }

    public void setCreated_on(LocalDateTime created_on) {
        this.created_on = created_on;
    }

    public List<Ticket> getEventTickets() {
        return eventTickets;
    }

    public void setEventTickets(List<Ticket> eventTickets) {
        this.eventTickets = eventTickets;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
