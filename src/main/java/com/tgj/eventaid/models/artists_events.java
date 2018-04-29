package com.tgj.eventaid.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artists")
public class artists_events {

    @Id
    @Column(nullable = false)
    private long artist_id;

    @Id
    @Column(nullable = false)
    private long event_id;

    public artists_events(long artist_id, long event_id) {
        this.artist_id = artist_id;
        this.event_id = event_id;
    }

    public long getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(long artist_id) {
        this.artist_id = artist_id;
    }

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }
}
