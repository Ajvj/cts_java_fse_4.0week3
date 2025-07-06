package com.example.countryquerymethods;

import com.example.countryquerymethods.model.Country;
import com.example.countryquerymethods.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CountryQueryMethodsApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(CountryQueryMethodsApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("🔍 Countries containing 'ou':");
        List<Country> result1 = countryService.searchByPartialName("ou");
        result1.forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));

        System.out.println("\n🔍 Countries containing 'ou' sorted by name:");
        List<Country> result2 = countryService.searchByPartialNameSorted("ou");
        result2.forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));

        System.out.println("\n🔤 Countries starting with 'Z':");
        List<Country> result3 = countryService.searchByStartingAlphabet("Z");
        result3.forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));
    }
}
