package com.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Scissors implements Specify {
    int length;
    private final String TITLE = "Scissors";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String returnTitle() {
        return TITLE;
    }
}
