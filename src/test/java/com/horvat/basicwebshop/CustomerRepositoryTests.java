package com.horvat.basicwebshop;

import static org.assertj.core.api.Assertions.assertThat;

import com.horvat.basicwebshop.model.Customer;
import com.horvat.basicwebshop.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CustomerRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    // This test will create new Customer in database with Crypted password so you can use this details to login
    @Test
    public void testCreateUser() {
        Customer customer = new Customer();
        customer.setEmail("josiph988@gmail.com");
        customer.setFirstName("Josip");
        customer.setLastName("Horvat");

        customer.setPassword("josip2021");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);


        Customer savedCustomer = customerRepository.save(customer);

        Customer existCustomer = entityManager.find(Customer.class, savedCustomer.getId());

        assertThat(customer.getEmail()).isEqualTo(existCustomer.getEmail());

    }
}
