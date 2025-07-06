package com.example.employeenativequerydemo;

import com.example.employeenativequerydemo.model.Employee;
import com.example.employeenativequerydemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EmployeeNativeQueryDemoApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeNativeQueryDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        List<Employee> employees = employeeService.fetchAllEmployees();
        System.out.println("All Employees (Using Native Query):");
        for (Employee e : employees) {
            System.out.println(e.getId() + " | " + e.getName() + " | " + e.getSalary());
        }
    }
}
