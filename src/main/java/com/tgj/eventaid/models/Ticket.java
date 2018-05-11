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

//            model.addAttribute("id", charge.getId());
//        model.addAttribute("status", charge.getStatus());
//        model.addAttribute("balance_transaction", charge.getBalanceTransaction());

    @Column(nullable = false)
    private String charge_id;

    @Column(nullable = false)
    private String charge_status;

    @Column(nullable = false)
    private String balance_transaction_id;

    @Column(nullable = false)
    private int balance_charged;

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
    public Ticket(long id, User user_id, int balance_charged, Timestamp purchased_on, Event event_id, String charge_id, String charge_status, String balance_transaction_id) {
        this.id = id;
        this.user_id = user_id;
        this.balance_charged = balance_charged;
        this.purchased_on = purchased_on;
        this.event_id = event_id;
        this.charge_id = charge_id;
        this.charge_status = charge_status;
        this.balance_transaction_id = balance_transaction_id;
    }

    // This is useful to get a full user obj
    public Ticket(User user_id, int balance_charged, Timestamp purchased_on, Event event_id, String charge_id, String charge_status, String balance_transaction_id) {
        this.id = id;
        this.user_id = user_id;
        this.balance_charged = balance_charged;
        this.purchased_on = purchased_on;
        this.event_id = event_id;
        this.charge_id = charge_id;
        this.charge_status = charge_status;
        this.balance_transaction_id = balance_transaction_id;
    }

    public Ticket(){}

    public String getCharge_id() {
        return charge_id;
    }

    public void setCharge_id(String charge_id) {
        this.charge_id = charge_id;
    }

    public String getCharge_status() {
        return charge_status;
    }

    public void setCharge_status(String charge_status) {
        this.charge_status = charge_status;
    }

    public String getBalance_transaction_id() {
        return balance_transaction_id;
    }

    public void setBalance_transaction_id(String balance_transaction_id) {
        this.balance_transaction_id = balance_transaction_id;
    }

    public int getBalance_charged() {
        return balance_charged;
    }

    public void setBalance_charged(int balance_charged) {
        this.balance_charged = balance_charged;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
