package com.example.stockquerydemo.controller;

import com.example.stockquerydemo.model.Stock;
import com.example.stockquerydemo.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/facebook-sep2019")
    public List<Stock> getFacebookSep2019() {
        return stockRepository.findByStCodeAndStDateBetween(
                "FB", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30)
        );
    }

    @GetMapping("/google-above-1250")
    public List<Stock> getGoogleAbove1250() {
        return stockRepository.findByStCodeAndStCloseGreaterThan("GOOGL", new BigDecimal("1250"));
    }

    @GetMapping("/top-volume")
    public List<Stock> getTopVolume() {
        return stockRepository.findTop3ByOrderByStVolumeDesc();
    }

    @GetMapping("/netflix-lowest")
    public List<Stock> getNetflixLowest() {
        return stockRepository.findTop3ByStCodeOrderByStCloseAsc("NFLX");
    }
}
