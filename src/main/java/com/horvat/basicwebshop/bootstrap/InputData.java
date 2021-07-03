package com.horvat.basicwebshop.bootstrap;


import com.github.javafaker.Faker;
import com.horvat.basicwebshop.model.*;
import com.horvat.basicwebshop.repository.CustomerRepository;
import com.horvat.basicwebshop.repository.OrderItemRepository;
import com.horvat.basicwebshop.repository.OrderRepository;
import com.horvat.basicwebshop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class InputData  implements ApplicationListener<ContextRefreshedEvent> {

    private final CustomerRepository customerRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public InputData(CustomerRepository customerRepository, OrderItemRepository orderItemRepository,
                     OrderRepository orderRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    Faker faker = new Faker();

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("***********************************************************");
        log.debug("****************LOADING DATA FROM BOOTSTRAP****************");
        log.debug("***********************************************************");

        if(customerRepository.findAll().size() <2){
            customerRepository.saveAll(getCustomers());
        }
        if(orderRepository.findAll().size()< 2){
            orderRepository.saveAll(getOrders());
        }
        if(productRepository.findAll().size()< 2){
            productRepository.saveAll(getProducts());
        }
        if(orderItemRepository.findAll().size()<2){
            orderItemRepository.saveAll(getOrderItem());
        }
    }

    private List<Customer> getCustomers() {

        List<Customer> customers = new ArrayList<>();

        Customer customerMike;
        customerMike = new Customer();
        customerMike.setFirstName("Mike");
        customerMike.setLastName(faker.name().lastName());
        customerMike.setEmail(faker.internet().emailAddress());
        customers.add(customerMike);

        Customer customerLynda;
        customerLynda = new Customer();
        customerLynda.setFirstName("Lynda");
        customerLynda.setLastName(faker.name().lastName());
        customerLynda.setEmail(faker.internet().emailAddress());
        customers.add(customerLynda);

       return  customers;
    }

    private List<Order> getOrders() {

        List<Order> orders = new ArrayList<>();

        Order mikesOrder;
        mikesOrder = new Order();
        mikesOrder.setStatus(Status.DRAFT);
        mikesOrder.setCustomer(customerRepository.getById(1L));
        mikesOrder.setTotalPriceHRK(100.0);
        mikesOrder.setTotalPriceEUR(mikesOrder.getTotalPriceHRK()*7);
        orders.add(mikesOrder);

        Order lyndasOrder;
        lyndasOrder = new Order();
        lyndasOrder.setStatus(Status.SUBMITTED);
        lyndasOrder.setCustomer(customerRepository.getById(2L));
        lyndasOrder.setTotalPriceHRK(200.0);
        lyndasOrder.setTotalPriceEUR(lyndasOrder.getTotalPriceHRK()* 7);
        orders.add(lyndasOrder);

        return orders;
    }

    private List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        Product productLaptop;
        productLaptop = new Product();
        productLaptop.setIsAvaible(faker.random().nextBoolean());
        productLaptop.setName(faker.funnyName().name());
        productLaptop.setCode("123456");
        productLaptop.setDescription(faker.lorem().paragraph(5));
        productLaptop.setPriceHRK(100.0);
        products.add(productLaptop);

        Product productPhone;
        productPhone = new Product();
        productPhone.setIsAvaible(faker.random().nextBoolean());
        productPhone.setName(faker.funnyName().name());
        productPhone.setCode("1awww456");
        productPhone.setDescription(faker.lorem().paragraph(5));
        productPhone.setPriceHRK(200.0);
        products.add(productPhone);

        return products;
    }

    private List<OrderItem> getOrderItem() {

        List<OrderItem> orderedItems = new ArrayList<>();

        OrderItem orderLaptop;
        orderLaptop = new OrderItem();
        orderLaptop.setProduct(productRepository.getById(1L));
        orderLaptop.setOrder(orderRepository.getById(1L));
        orderLaptop.setQuantity(1);
        orderedItems.add(orderLaptop);

        OrderItem orderPhone;
        orderPhone = new OrderItem();
        orderPhone.setProduct(productRepository.getById(2l));
        orderPhone.setOrder(orderRepository.getById(2l));
        orderPhone.setQuantity(3);
        orderedItems.add(orderPhone);
        return  orderedItems;
    }
}
