package com.example.stockquerydemo;

import com.example.stockquerydemo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockQueryDemoApplication implements CommandLineRunner {

    @Autowired
    private StockService stockService;

    public static void main(String[] args) {
        SpringApplication.run(StockQueryDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        stockService.runQueries();
    }
}
