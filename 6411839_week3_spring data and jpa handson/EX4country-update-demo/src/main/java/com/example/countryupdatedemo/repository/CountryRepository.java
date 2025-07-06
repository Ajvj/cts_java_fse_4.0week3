package com.example.countryupdatedemo.repository;

import com.example.countryupdatedemo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}
