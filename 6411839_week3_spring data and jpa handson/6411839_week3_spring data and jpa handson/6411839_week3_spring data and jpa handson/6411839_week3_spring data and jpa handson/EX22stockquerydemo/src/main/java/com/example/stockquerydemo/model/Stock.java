package com.example.stockquerydemo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stId;

    private String stCode;

    private LocalDate stDate;

    private BigDecimal stOpen;

    private BigDecimal stClose;

    private BigDecimal stVolume;

    // Getters and Setters

    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    public String getStCode() {
        return stCode;
    }

    public void setStCode(String stCode) {
        this.stCode = stCode;
    }

    public LocalDate getStDate() {
        return stDate;
    }

    public void setStDate(LocalDate stDate) {
        this.stDate = stDate;
    }

    public BigDecimal getStOpen() {
        return stOpen;
    }

    public void setStOpen(BigDecimal stOpen) {
        this.stOpen = stOpen;
    }

    public BigDecimal getStClose() {
        return stClose;
    }

    public void setStClose(BigDecimal stClose) {
        this.stClose = stClose;
    }

    public BigDecimal getStVolume() {
        return stVolume;
    }

    public void setStVolume(BigDecimal stVolume) {
        this.stVolume = stVolume;
    }

    // toString method for readable output in console

    @Override
    public String toString() {
        return "Stock{" +
                "stId=" + stId +
                ", stCode='" + stCode + '\'' +
                ", stDate=" + stDate +
                ", stOpen=" + stOpen +
                ", stClose=" + stClose +
                ", stVolume=" + stVolume +
                '}';
    }
}
