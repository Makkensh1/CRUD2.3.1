package com.test.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Role(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "employee")
    private Collection<Employee> employees;

}
