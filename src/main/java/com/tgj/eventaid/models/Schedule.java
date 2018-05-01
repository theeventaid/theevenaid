package com.tgj.eventaid.models;


import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue
    private long id;

//    @OneToOne
//    private Event event_id;

    @Column(nullable = false)
    private Time start_time;

    @Column(nullable = false)
    private Time end_time;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String location;

    @ManyToOne  // relationship to events.id
    @JoinColumn (name = "event_id")
    private Event event_id;

    @ManyToOne  // relationship to events.id
    @JoinColumn (name = "artist_id")
    private Artist artist_id;

    // artist_id is foreign key to artists.id, and event_id is foreign key to events.id

    public Schedule(long id, long event_id, Time start_time, Time end_time, String subject, String location) {
        this.id= id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.subject = subject;
        this.location = location;
    }

    public Schedule(long event_id, Time start_time, Time end_time, String subject, String location) {
        this.start_time = start_time;
        this.end_time = end_time;
        this.subject = subject;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Event getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Event event_id) {
        this.event_id = event_id;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Artist getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(Artist artist_id) {
        this.artist_id = artist_id;
    }
}
