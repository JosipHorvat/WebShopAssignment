package com.horvat.basicwebshop.service.servicesimpl;

import com.horvat.basicwebshop.model.Customer;
import com.horvat.basicwebshop.repository.CustomerRepository;
import com.horvat.basicwebshop.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Set<Customer> getCustomers() {
        Set<Customer> customerSet = new HashSet<>();
        customerRepository.findAll().iterator().forEachRemaining(customerSet::add);
        log.debug("U customer servisu sam");
        return customerSet;
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(!customerOptional.isPresent()){
            throw  new RuntimeException("Customer not found");
        }
        return customerOptional.get();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long idToDelete) {
    customerRepository.deleteById(idToDelete);
    }
}
