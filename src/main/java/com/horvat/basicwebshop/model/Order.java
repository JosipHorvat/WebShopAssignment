package com.horvat.basicwebshop.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "webshop_order") // order is reserved keyword in SQL
public class Order extends BaseEntity {


    public Order(Long id, Double totalPriceHRK, Double totalPriceEUR, Status status,
                 Customer customer, Set<OrderItem> orderedItems) {
        super(id);
        this.totalPriceHRK = totalPriceHRK;
        this.totalPriceEUR = totalPriceEUR;
        this.status = status;
        this.customer = customer;
        if(orderedItems != null){
            this.orderedItems = orderedItems;
        }
    }

    private Double totalPriceHRK;
    private Double totalPriceEUR;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<OrderItem> orderedItems = new HashSet<>();
}
