package com.tgj.eventaid.models;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private BigDecimal event_budget;

    @Column(nullable = false)
    private BigDecimal target_spending;

    @Column(nullable = false)
    private BigDecimal target_profit;

    @ManyToOne  // relationship to events.id
    @JoinColumn (name = "event_id")
    private Event event;

    // display object
    public Budget(long id, BigDecimal event_budget, BigDecimal target_spending, BigDecimal target_profit, Event event) {
        this.id = id;
        this.event_budget = event_budget;
        this.target_spending = target_spending;
        this.target_profit = target_profit;
        this.event= event;
    }

    //insert object
    public Budget(BigDecimal event_budget, BigDecimal target_spending, BigDecimal target_profit, Event event) {
        this.event_budget = event_budget;
        this.target_spending = target_spending;
        this.target_profit = target_profit;
        this.event = event;
    }

    public Budget(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getEvent_budget() {
        return event_budget;
    }

    public void setEvent_budget(BigDecimal event_budget) {
        this.event_budget = event_budget;
    }

    public BigDecimal getTarget_spending() {
        return target_spending;
    }

    public void setTarget_spending(BigDecimal target_spending) {
        this.target_spending = target_spending;
    }

    public BigDecimal getTarget_profit() {
        return target_profit;
    }

    public void setTarget_profit(BigDecimal target_profit) {
        this.target_profit = target_profit;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
