package com.horvat.basicwebshop.model;

import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItem extends BaseEntity{

    public OrderItem(Long id, Integer quantity, Order order, Product product) {
        super(id);
        this.quantity = quantity;
        this.order = order;
        if(product != null){
            this.product = product;
        }
    }

    private Integer quantity;

    @ManyToOne
    private Order order;

    @OneToOne( cascade =  CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
}
