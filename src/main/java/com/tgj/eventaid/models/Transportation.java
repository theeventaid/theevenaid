package com.tgj.eventaid.models;


import javax.persistence.*;
import java.sql.*;

@Entity
@Table(name = "transportation")
public class Transportation {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne  // relationship to events.id
    @JoinColumn (name = "artist_id")
    private Artist artist_id;

    @Column(nullable = false)
    private Date pickup;

    @Column(nullable = false)
    private Date dropoff;

    @Column(nullable = false)
    private String uber_code;

    @Column(nullable = false)
    private double uber_cost;

    // finished setting table logic

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getPickup() {
        return pickup;
    }

    public void setPickup(Date pickup) {
        this.pickup = pickup;
    }

    public Date getDropoff() {
        return dropoff;
    }

    public void setDropoff(Date dropoff) {
        this.dropoff = dropoff;
    }

    public String getUber_code() {
        return uber_code;
    }

    public void setUber_code(String uber_code) {
        this.uber_code = uber_code;
    }

    public double getUber_cost() {
        return uber_cost;
    }

    public void setUber_cost(double uber_cost) {
        this.uber_cost = uber_cost;
    }

    public Artist getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(Artist artist_id) {
        this.artist_id = artist_id;
    }
}
