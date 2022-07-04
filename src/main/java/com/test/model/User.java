package com.test.model;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User extends Human {

    private double cash;

    @Transient
    transient private final Role ROLE = new Role("ROLE_USER");

    public User() {
        this.cash = 0.0;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    @OneToMany(mappedBy = "id")
    private Collection<Order> order;

    public Collection<Order> getOrder() {
        return order;
    }

    public void setOrder(Collection<Order> order) {
        this.order = order;
    }

    public Role getROLE() {
        return ROLE;
    }
}