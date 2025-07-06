package com.example.countryupdatedemo;

import com.example.countryupdatedemo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryUpdateDemoApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(CountryUpdateDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🔁 Updating country name for code = 'IN'");
        countryService.updateCountry("IN", "Bharat");
        System.out.println("✅ Update complete. Please check database.");
    }
}
