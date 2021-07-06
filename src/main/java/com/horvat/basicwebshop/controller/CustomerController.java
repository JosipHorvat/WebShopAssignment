package com.horvat.basicwebshop.controller;

import com.horvat.basicwebshop.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @RequestMapping("customers")
    public String getIndexPage(Model model){
        model.addAttribute("customers", customerService.getCustomers());

        return "customer/index";
    }
}
