package com.example.productsearchcriteriaquery;

import com.example.productsearchcriteriaquery.model.Product;
import com.example.productsearchcriteriaquery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductSearchCriteriaQueryApplication implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(ProductSearchCriteriaQueryApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Example: search for products with OS = "Windows" and RAM = 16
        List<Product> products = productService.searchProducts("Windows", 16, null);

        System.out.println("\n🔍 Filtered Products:");
        for (Product p : products) {
            System.out.println(p.getId() + " | " + p.getName() + " | " + p.getCpu() +
                    " | " + p.getOs() + " | " + p.getRam() + "GB | Rating: " + p.getRating());
        }
    }
}
