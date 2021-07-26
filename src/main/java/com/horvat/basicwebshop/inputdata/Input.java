package com.horvat.basicwebshop.inputdata;

import com.horvat.basicwebshop.model.Product;
import com.horvat.basicwebshop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class Input implements ApplicationListener<ContextRefreshedEvent> {

    private final ProductRepository productRepository;

    public Input(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
      //  productRepository.saveAll(getProducts());
    }

    private List<Product> getProducts(){
        List<Product> products = new ArrayList<>();

        Product pc = new Product();
        pc.setPriceHRK(120.0);
        pc.setName("Dell laptop");
        pc.setIsAvaible(true);
        pc.setCode("123456789");
        pc.setDescription("Laptop for personal use");
        products.add(pc);

        Product phone = new Product();
        phone.setPriceHRK(20.22);
        phone.setName("Samsung");
        phone.setIsAvaible(false);
        phone.setCode("987654321");
        phone.setDescription("Cool Samsung phone");
        products.add(phone);

        return products;
    }
}
