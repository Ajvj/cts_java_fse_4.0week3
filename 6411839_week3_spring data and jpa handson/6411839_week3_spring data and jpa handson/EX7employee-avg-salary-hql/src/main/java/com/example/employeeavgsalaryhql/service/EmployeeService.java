package com.example.employeeavgsalaryhql.service;

import com.example.employeeavgsalaryhql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public double getAverageSalaryByDepartmentId(int id) {
        return employeeRepository.getAverageSalary(id);
    }
}
