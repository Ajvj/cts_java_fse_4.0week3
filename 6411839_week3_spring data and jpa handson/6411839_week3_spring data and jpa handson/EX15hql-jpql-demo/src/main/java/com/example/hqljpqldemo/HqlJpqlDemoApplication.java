package com.example.hqljpqldemo;

import com.example.hqljpqldemo.model.Employee;
import com.example.hqljpqldemo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HqlJpqlDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HqlJpqlDemoApplication.class, args);
    }

    // Load sample data at startup
    @Bean
    public CommandLineRunner loadData(EmployeeRepository repository) {
        return args -> {
            repository.save(new Employee(null, "Ajay", "IT", 75000));
            repository.save(new Employee(null, "Priya", "IT", 82000));
            repository.save(new Employee(null, "John", "HR", 45000));
            repository.save(new Employee(null, "Meena", "Finance", 90000));
        };
    }
}
