package com.tgj.eventaid.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "event_tickets")
public class Ticket {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Timestamp purchased_on;

    @ManyToOne  // must add a foreign key to user_id from event_tickets
    @JoinColumn (name = "user_id")
    private User user_id;

    @ManyToOne  // relationship to events.id
    @JoinColumn (name = "event_id")
    private Event event_id;

    // users_events will be a pivot table between events and users on user_id and events_id

    // This is useful to insert users
    public Ticket(long id, User user_id, BigDecimal price, Timestamp purchased_on, Event event_id) {
        this.id = id;
        this.price = price;
        this.purchased_on = purchased_on;
        this.event_id = event_id;
    }

    // This is useful to get a full user obj
    public Ticket(User user_id, BigDecimal price, Timestamp purchased_on, Event event_id) {
        this.price = price;
        this.purchased_on = purchased_on;
        this.event_id = event_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Timestamp getPurchased_on() {
        return purchased_on;
    }

    public void setPurchased_on(Timestamp purchased_on) {
        this.purchased_on = purchased_on;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Event getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Event event_id) {
        this.event_id = event_id;
    }
}
