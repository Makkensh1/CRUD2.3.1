package com.test.model;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table
public class Employee extends Human {

    private double salary;

    @Enumerated
    private Position position;

    @ManyToMany
    @JoinTable(
            name = "employee_roles",
            joinColumns = @JoinColumn(
                    name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;
}



enum Position {
    Manager,
    Admin
}