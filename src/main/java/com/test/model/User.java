package com.test.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User extends Human {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double cash;


    public User(String name, String surName, String email, double cash) {
        super(name, surName, email);
        this.cash = cash;
    }

    public User() {
        this.cash = 0.0;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    @Override
    public long getId() {
        return id;
    }

}