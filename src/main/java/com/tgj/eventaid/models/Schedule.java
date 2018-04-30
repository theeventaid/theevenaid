package com.tgj.eventaid.models;


import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT(12) UNSIGNED")
    private long id;

    @OneToOne
    private Event event;

    @Column(nullable = false)
    private Time start_time;

    @Column(nullable = false)
    private Time end_time;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String location;

    @OneToOne
    private Artist artist;

    public Schedule() {}

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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
