package com.tgj.eventaid.models;


import javax.persistence.*;
import java.sql.*;

@Entity
@Table(name = "transportation")
public class Transportation {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private long artists_id;

    @Column(nullable = false)
    private Date pickup;

    @Column(nullable = false)
    private Date dropoff;

    @Column(nullable = false)
    private String uber_code;

    @Column(nullable = false)
    private double uber_cost;

    // artist_id is foreign key to artists.id


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getArtists_id() {
        return artists_id;
    }

    public void setArtists_id(long artists_id) {
        this.artists_id = artists_id;
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
}
