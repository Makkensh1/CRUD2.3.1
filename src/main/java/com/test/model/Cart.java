package com.test.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
@Data
@RequiredArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private User cartOwner;

    private double cartCost;

    private boolean statusPaid;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_list",
            joinColumns = @JoinColumn(
                    name = "cart_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "product_id", referencedColumnName = "id"))

    private List<Product> productList;

}
