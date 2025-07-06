package com.example.productsearchcriteriaquery.repository;

import com.example.productsearchcriteriaquery.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
