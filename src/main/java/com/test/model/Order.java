package com.test.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Order {

    @ManyToOne
    @JoinColumn(name = "email")
    private User orderOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private double orderCost;

    @OneToMany
    private List<Product> productList;

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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}


