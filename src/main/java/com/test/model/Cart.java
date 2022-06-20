package com.test.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "email")
    private  User cartOwner;



    private double cartCost;

    private boolean statusPaid;

    public Cart(User user, double cartCost) {
        this.cartOwner = user;

        this.cartCost = cartCost;
        this.statusPaid = false;
    }



    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public User getCartOwner() {
        return cartOwner;
    }



    public double getCartCost() {
        return cartCost;
    }

    public void setCartCost(double cartCost) {
        this.cartCost = cartCost;
    }

    public boolean isStatusPaid() {
        return statusPaid;
    }

    public void setStatusPaid(boolean statusPaid) {
        this.statusPaid = statusPaid;
    }

}
