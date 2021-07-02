package com.horvat.basicwebshop.repository;

import com.horvat.basicwebshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderRepository  extends JpaRepository<Order, Long> , JpaSpecificationExecutor<Order> {
}
