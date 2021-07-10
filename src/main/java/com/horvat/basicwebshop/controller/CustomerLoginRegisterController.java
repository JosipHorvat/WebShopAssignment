package com.horvat.basicwebshop.controller;

import com.horvat.basicwebshop.model.Customer;
import com.horvat.basicwebshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerLoginRegisterController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(Customer customer) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);

        customerRepository.save(customer);

        return "register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<Customer> listCustomers = customerRepository.findAll();
        model.addAttribute("listUsers", listCustomers);

        return "users";
    }
}
