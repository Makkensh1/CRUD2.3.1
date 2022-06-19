package com.test.model;

import org.springframework.stereotype.Component;

public class Employee extends Human {

    private double salary;
    private Position position;


}

@Component
enum Position {
    Manager,
    Storekeeper
}