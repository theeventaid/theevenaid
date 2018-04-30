package com.tgj.eventaid.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "event_tickets")
public class Tickets {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private long user_id;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Timestamp purchased_on;

    @Column(nullable = false)
    private long event_id;

    @OneToOne  // must add a foreign key to user_id from event_tickets
    private Users user;

    // users_events will be a pivot table between events and users on user_id and events_id

    // This is useful to insert users
    public Tickets(long id, long user_id, BigDecimal price, Timestamp purchased_on, long event_id) {
        this.id = id;
        this.price = price;
        this.purchased_on = purchased_on;
        this.event_id = event_id;
    }

    // This is useful to get a full user obj
    public Tickets(long user_id, BigDecimal price, Timestamp purchased_on, long event_id) {
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }
}
