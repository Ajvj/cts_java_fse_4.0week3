package com.example.stockquerydemo.repository;

import com.example.stockquerydemo.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal; // ✅ This line is necessary!
import java.time.LocalDate;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findByStCodeAndStDateBetween(String stCode, LocalDate start, LocalDate end);

    List<Stock> findByStCodeAndStCloseGreaterThan(String stCode, BigDecimal price);

    List<Stock> findTop3ByOrderByStVolumeDesc();

    List<Stock> findTop3ByStCodeOrderByStCloseAsc(String stCode);
}
