package com.example.hqljpqldemo.service;

import com.example.hqljpqldemo.model.Employee;
import com.example.hqljpqldemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }

    public List<Employee> getEmployeesByDepartment(String dept) {
        return employeeRepository.findByDepartmentJPQL(dept);
    }

    public List<Employee> getHighSalaryEmployees(double minSalary) {
        return employeeRepository.findEmployeesWithSalaryGreaterThan(minSalary);
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
