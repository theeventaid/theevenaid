package com.tgj.eventaid.models;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "venues")
public class venues {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT(12) UNSIGNED")
    private long id;

    @Column(nullable = false)
    private BigDecimal costs;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private boolean contract;

    @Column(nullable = false)
    private String contract_location;

    public venues(long id,BigDecimal costs, String address, boolean contract, String contract_location) {
        this.id = id;
        this.costs = costs;
        this.address = address;
        this.contract = contract;
        this.contract_location = contract_location;
    }

    public venues(BigDecimal costs, String address, boolean contract, String contract_location) {
        this.costs = costs;
        this.address = address;
        this.contract = contract;
        this.contract_location = contract_location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
