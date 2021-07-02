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

    @OneToOne( cascade =  CascadeType.ALL, mappedBy = "product")
    private OrderItem orderItem;
}
