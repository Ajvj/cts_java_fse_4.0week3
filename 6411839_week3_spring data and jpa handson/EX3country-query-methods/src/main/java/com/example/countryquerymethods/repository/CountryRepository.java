package com.example.countryquerymethods.repository;

import com.example.countryquerymethods.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    // 1️⃣ Match any part of name (contains)
    List<Country> findByNameContaining(String text);

    // 2️⃣ Match and sort by name ascending
    List<Country> findByNameContainingOrderByNameAsc(String text);

    // 3️⃣ Countries that start with a specific letter
    List<Country> findByNameStartingWith(String prefix);
}
