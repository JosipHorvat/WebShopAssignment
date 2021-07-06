package com.horvat.basicwebshop.service;

import com.horvat.basicwebshop.model.Customer;

import java.util.Set;

public interface CustomerService {

    Set<Customer> getCustomers();
    Customer findById(Long id);
    Customer saveCustomer(Customer customer);
    void deleteById(Long idToDelete);

}
