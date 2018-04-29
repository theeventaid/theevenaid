package com.tgj.eventaid.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_events")
public class users_events {

    @Id
    @Column(nullable = false)
    private long event_id;

    @Id
    @Column(nullable = false)
    private long user_id;

    public users_events(long event_id, long user_id) {
        this.event_id = event_id;
        this.user_id = user_id;
    }

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
