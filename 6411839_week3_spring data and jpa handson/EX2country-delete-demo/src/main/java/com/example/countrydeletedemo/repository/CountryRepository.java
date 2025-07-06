package com.example.countrydeletedemo.repository;

import com.example.countrydeletedemo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}
