package com.tgj.eventaid.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT(12) UNSIGNED")
    private long id;

    @OneToOne
    private User user;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Timestamp purchased_on;

    @Column(nullable = false)
    private String name;


    public Ticket(long id, long user_id, BigDecimal price, Timestamp purchased_on, String name) {
        this.id = id;
        this.price = price;
        this.purchased_on = purchased_on;
        this.name = name;
    }

    public Ticket(long user_id, BigDecimal price, Timestamp purchased_on, String name) {
        this.price = price;
        this.purchased_on = purchased_on;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
