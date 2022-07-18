package com.test.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public abstract class Human {

    @Id
    @GeneratedValue()
    protected Long id;

    @Column(name = "name")
    protected String name;
    @Column(name = "surname")
    protected String surName;

    @Column(name = "email")
    protected String email;

    @Column(name = "password")
    protected String password;

    @Transient
    transient private String confirmPassword;

}
