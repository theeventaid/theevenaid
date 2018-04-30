package com.tgj.eventaid.models;


import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
@Table(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT(12) UNSIGNED")
    private long id;

    @Column(nullable = false)
    private BigDecimal event_budget;

    @Column(nullable = false)
    private BigDecimal target_spending;

    @Column(nullable = false)
    private BigDecimal target_profit;

    @Column(nullable = false)
    private Integer event_id;

    public Budget(long id, BigDecimal event_budget, BigDecimal target_spending, BigDecimal target_profit, Integer event_id) {
        this.id = id;
        this.event_budget = event_budget;
        this.target_spending = target_spending;
        this.target_profit = target_profit;
        this.event_id = event_id;
    }

    public Budget(BigDecimal event_budget, BigDecimal target_spending, BigDecimal target_profit, Integer event_id) {
        this.event_budget = event_budget;
        this.target_spending = target_spending;
        this.target_profit = target_profit;
        this.event_id = event_id;
    }

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

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }
}
