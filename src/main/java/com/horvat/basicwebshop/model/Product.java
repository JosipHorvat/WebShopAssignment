package com.horvat.basicwebshop.model;

import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    private String code;
    private String name;
    private Double priceHRK;
    private String description;
    private Boolean isAvaible;

    public Product(Long id, String code, String name, Double priceHRK, String description,
                   Boolean isAvaible, OrderItem orderItem) {
        super(id);
        this.code = code;
        this.name = name;
        this.priceHRK = priceHRK;
        this.description = description;
        this.isAvaible = isAvaible;
        if(orderItem != null){
            this.orderItem = orderItem;
        }
    }

    @OneToOne( cascade =  CascadeType.ALL, mappedBy = "product")
    private OrderItem orderItem;
}
