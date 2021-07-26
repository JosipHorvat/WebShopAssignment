package com.horvat.basicwebshop.service;

import com.horvat.basicwebshop.model.Product;

import java.util.Set;

public interface ProductService {

    Set<Product> getProducts();

    Product findById(Long id);

    void deleteById(Long idToDelete);

    Product save(Product product);
}
