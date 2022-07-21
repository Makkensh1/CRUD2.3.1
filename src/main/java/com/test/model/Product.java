package com.test.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Product {

    private String manufacturer;

    private double cost;

    private String type;

    private String paramName;

    private String paramValue;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long stockBalance;

}

