package com.test.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Order {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "email")
    private User orderOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double orderCost;

    public User getOrderOwner() {
        return orderOwner;
    }
}


