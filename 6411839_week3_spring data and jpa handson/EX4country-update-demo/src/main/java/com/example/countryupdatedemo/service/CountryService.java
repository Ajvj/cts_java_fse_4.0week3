package com.example.countryupdatedemo.service;

import com.example.countryupdatedemo.model.Country;
import com.example.countryupdatedemo.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public void updateCountry(String code, String name) {
        Country country = countryRepository.findById(code).orElseThrow(() ->
                new RuntimeException("Country not found with code: " + code));
        country.setName(name);
        countryRepository.save(country);
    }
}
