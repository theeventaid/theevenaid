package com.tgj.eventaid.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "artists")
public class event_tickets {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT(12) UNSIGNED")
    private long id;

    @Id
    @Column
    private long user_id;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Timestamp purchased_on;

    @Column(nullable = false)
    private String name;


    public event_tickets(long id,long user_id, BigDecimal price, Timestamp purchased_on, String name) {
        this.id = id;
        this.user_id = user_id;
        this.price = price;
        this.purchased_on = purchased_on;
        this.name = name;
    }

    public event_tickets(long user_id, BigDecimal price, Timestamp purchased_on, String name) {
        this.user_id = user_id;
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

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
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
