package com.test.model;

public abstract class Human {

    private long id;

    private String name;
    private String surName;

    private String email;

    public Human() {
    }

    public Human(String name, String surName, String email) {
        this.name = name;
        this.surName = surName;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }
}
