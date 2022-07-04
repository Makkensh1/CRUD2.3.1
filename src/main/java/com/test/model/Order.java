package com.test.model;

import javax.persistence.*;

@Entity
@Table
public class Order {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="email")
    private  User orderOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private double orderCost;

    public User getOrderOwner() {
        return orderOwner;
    }

    public void setOrderOwner(User orderOwner) {
        this.orderOwner = orderOwner;
    }

    public long getId() {
        return id;
    }

    public double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(double orderCost) {
        this.orderCost = orderCost;
    }


}


