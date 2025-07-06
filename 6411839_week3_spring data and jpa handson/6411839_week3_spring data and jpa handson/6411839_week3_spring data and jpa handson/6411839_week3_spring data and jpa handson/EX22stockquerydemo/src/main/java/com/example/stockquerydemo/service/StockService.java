package com.example.stockquerydemo.service;

import com.example.stockquerydemo.model.Stock;
import com.example.stockquerydemo.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public void runQueries() {
        System.out.println("Facebook Stocks in Sep 2019:");
        List<Stock> fbStocks = stockRepository.findByStCodeAndStDateBetween(
                "FB",
                LocalDate.of(2019, 9, 1),
                LocalDate.of(2019, 9, 30)
        );
        fbStocks.forEach(System.out::println);

        System.out.println("\nGoogle Stocks > 1250:");
        List<Stock> googleStocks = stockRepository.findByStCodeAndStCloseGreaterThan("GOOGL", new BigDecimal("1250"));
        googleStocks.forEach(System.out::println);

        System.out.println("\nTop 3 Highest Volume Days:");
        stockRepository.findTop3ByOrderByStVolumeDesc().forEach(System.out::println);

        System.out.println("\nNetflix Lowest 3 Close Prices:");
        stockRepository.findTop3ByStCodeOrderByStCloseAsc("NFLX").forEach(System.out::println);
    }
}
