package com.test.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Order {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User orderOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double orderCost;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
}


