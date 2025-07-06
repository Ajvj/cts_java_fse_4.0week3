package com.example.countrydeletedemo;

import com.example.countrydeletedemo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryDeleteDemoApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(CountryDeleteDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("❌ Deleting country with code = 'IN'");
        countryService.deleteCountry("IN");
        System.out.println("✅ Country deleted. Please verify in the DB.");
    }
}
