package com.example.countryquerymethods.service;

import com.example.countryquerymethods.model.Country;
import com.example.countryquerymethods.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> searchByPartialName(String text) {
        return countryRepository.findByNameContaining(text);
    }

    public List<Country> searchByPartialNameSorted(String text) {
        return countryRepository.findByNameContainingOrderByNameAsc(text);
    }

    public List<Country> searchByStartingAlphabet(String alphabet) {
        return countryRepository.findByNameStartingWith(alphabet);
    }
}
