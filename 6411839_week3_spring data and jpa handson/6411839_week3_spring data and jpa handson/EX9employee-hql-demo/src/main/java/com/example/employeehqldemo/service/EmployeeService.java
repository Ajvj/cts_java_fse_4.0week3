package com.example.employeehqldemo.service;

import com.example.employeehqldemo.model.Employee;
import com.example.employeehqldemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllPermanentEmployees() {
        return repository.getAllPermanentEmployees();
    }
}
