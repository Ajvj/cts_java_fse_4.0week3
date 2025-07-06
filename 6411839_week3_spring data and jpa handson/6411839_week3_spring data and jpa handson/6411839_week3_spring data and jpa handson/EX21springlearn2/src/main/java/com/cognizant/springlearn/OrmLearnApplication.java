package com.cognizant.springlearn;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        CountryService countryService = context.getBean(CountryService.class);

        testAddCountry(countryService);
    }

    public static void testAddCountry(CountryService countryService) {
        LOGGER.info("START testAddCountry");

        // ✅ Create new country
        Country newCountry = new Country();
        newCountry.setCode("JP");
        newCountry.setName("Japan");

        // ✅ Save it to the DB
        countryService.addCountry(newCountry);

        // ✅ Fetch and display
        try {
            Country fetchedCountry = countryService.findCountryByCode("JP");
            System.out.println("Fetched Country: Code = " + fetchedCountry.getCode() +
                               ", Name = " + fetchedCountry.getName());
        } catch (CountryNotFoundException e) {
            e.printStackTrace();
        }

        LOGGER.info("END testAddCountry");
    }
}
