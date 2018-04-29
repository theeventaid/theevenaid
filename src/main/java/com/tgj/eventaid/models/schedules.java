package com.tgj.eventaid.models;


import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "artists")
public class schedules {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT(12) UNSIGNED")
    private long id;

    @Id
    @Column(nullable = false)
    private long event_id;

    @Column(nullable = false)
    private Time start_time;

    @Column(nullable = false)
    private Time end_time;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String location;

    @Id
    @Column(nullable = false)
    private long artist_id;

    public schedules(long id,long event_id, Time start_time, Time end_time, String subject, String location, long artist_id) {
        this.id= id;
        this.event_id = event_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.subject = subject;
        this.location = location;
        this.artist_id = artist_id;
    }

    public schedules(long event_id, Time start_time, Time end_time, String subject, String location, long artist_id) {
        this.event_id = event_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.subject = subject;
        this.location = location;
        this.artist_id = artist_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
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

    public long getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(long artist_id) {
        this.artist_id = artist_id;
    }
}
