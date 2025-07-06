package com.example.productsearchcriteriaquery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpu;

    private String os;

    private int ram; // in GB

    @Column(name = "hard_disk")
    private int hardDisk; // in GB

    @Column(name = "cpu_speed")
    private double cpuSpeed; // in GHz

    private double weight; // in kg

    private int rating; // 1 to 5

    // ✅ Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpu() {
        return cpu;
    }

    public String getOs() {
        return os;
    }

    public int getRam() {
        return ram;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public double getCpuSpeed() {
        return cpuSpeed;
    }

    public double getWeight() {
        return weight;
    }

    public int getRating() {
        return rating;
    }

    // ✅ Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHardDisk(int hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void setCpuSpeed(double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
