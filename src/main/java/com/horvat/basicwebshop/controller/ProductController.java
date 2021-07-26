package com.horvat.basicwebshop.controller;

import com.horvat.basicwebshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class ProductController {

    @Autowired private  final ProductService productService;

    @RequestMapping("/index")
    public String getAllProducts(Model model){
        model.addAttribute("products", productService.getProducts());
        return "index";
    }

    // nakon ovoga dodaj listu proizvoda u html
}


