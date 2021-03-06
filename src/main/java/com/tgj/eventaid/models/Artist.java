package com.tgj.eventaid.models;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue
    private long id;

    @Column()
    private String name;

    @Column()
    private BigDecimal costs;

    @Column()
    private boolean contract;

    @Column()
    private String contract_location;

    @Column
    private String notes;

    @ManyToOne  // relationship to events.id
    @JoinColumn (name = "event_id")
    public Event event;

    // empty constructor
    public Artist(){}

    //pull object
    public Artist(long id, String name, BigDecimal costs, boolean contract, String contract_location, String notes) {
        this.id = id;
        this.name = name;
        this.costs = costs;
        this.contract = contract;
        this.contract_location = contract_location;
        this.notes = notes;
    }

    //insert object
    public Artist(String name, BigDecimal costs, boolean contract, String contract_location, String notes, Event event) {
        this.name = name;
        this.costs = costs;
        this.contract = contract;
        this.contract_location = contract_location;
        this.notes = notes;
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public boolean isContract() {
        return contract;
    }

    public void setContract(boolean contract) {
        this.contract = contract;
    }

    public String getContract_location() {
        return contract_location;
    }

    public void setContract_location(String contract_location) {
        this.contract_location = contract_location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
