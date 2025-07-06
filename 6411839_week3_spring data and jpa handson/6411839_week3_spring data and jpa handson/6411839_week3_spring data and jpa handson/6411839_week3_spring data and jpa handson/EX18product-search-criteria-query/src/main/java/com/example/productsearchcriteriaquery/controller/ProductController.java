package com.example.productsearchcriteriaquery.controller;

import com.example.productsearchcriteriaquery.model.Product;
import com.example.productsearchcriteriaquery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public List<Product> search(
            @RequestParam(required = false) String os,
            @RequestParam(required = false) Integer ram,
            @RequestParam(required = false) String cpu) {

        return productService.searchProducts(os, ram, cpu);
    }
}
