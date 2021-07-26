package com.horvat.basicwebshop.service.servicesimpl;

import com.horvat.basicwebshop.model.Product;
import com.horvat.basicwebshop.repository.ProductRepository;
import com.horvat.basicwebshop.service.ProductService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Set<Product> getProducts() {
        Set<Product> productSet = new HashSet<>();
        productRepository.findAll().iterator().forEachRemaining(productSet::add);
        return productSet;
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if(!productOptional.isPresent()){
            try {
                throw new NotFoundException("Product not found! For ID value: " + id.toString());
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        return productOptional.get();
    }

    @Override
    public void deleteById(Long idToDelete) {
    productRepository.deleteById(idToDelete);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
