package com.example.employeenativequerydemo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double salary;
    private boolean permanent;

    @Column(name = "department_id")
    private int departmentId;

    // ✅ Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    // ✅ Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
