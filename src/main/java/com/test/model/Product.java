package com.test.model;

import javax.persistence.*;


@Entity
public  class Product  <T> {

    private String manufacturer;

    private double cost;


    private T productType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long stockBalance;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String title) {
        this.manufacturer = title;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Product(String manufacturer, double cost, T productType, long stockBalance) {
        this.manufacturer = manufacturer;
        this.cost = cost;
        this.productType = productType;
        this.stockBalance = stockBalance;
    }

    public Product() {
    }

}

