package com.horvat.basicwebshop.model;

import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItem extends BaseEntity{

    private Integer quantity;

    @ManyToOne
    private Order order;

    @OneToOne( cascade =  CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
}
