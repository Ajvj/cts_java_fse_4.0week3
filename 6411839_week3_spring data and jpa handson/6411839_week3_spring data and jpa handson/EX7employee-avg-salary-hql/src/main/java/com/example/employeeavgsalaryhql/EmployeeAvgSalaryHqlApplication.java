package com.example.employeeavgsalaryhql;

import com.example.employeeavgsalaryhql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeAvgSalaryHqlApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeAvgSalaryHqlApplication.class, args);
    }

    @Override
    public void run(String... args) {
        int deptId = 1;
        double avgSalary = employeeService.getAverageSalaryByDepartmentId(deptId);
        System.out.println("Average Salary in Department " + deptId + ": " + avgSalary);
    }
}

