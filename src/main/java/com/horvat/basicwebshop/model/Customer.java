package com.horvat.basicwebshop.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer extends  BaseEntity {


    public Customer(Long id, String firstName, String lastName, String email, Set<Order> orders) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        if(orders != null){
            this.orders = orders;
        }
    }

    private String firstName;
    private String lastName;
    private  String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Order> orders = new HashSet<>();
}
