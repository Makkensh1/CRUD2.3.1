package com.test.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table
@Getter
public class Employee extends Human {

    private double salary;

    @ManyToMany
    @JoinTable(
            name = "employee_roles",
            joinColumns = @JoinColumn(
                    name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

}



