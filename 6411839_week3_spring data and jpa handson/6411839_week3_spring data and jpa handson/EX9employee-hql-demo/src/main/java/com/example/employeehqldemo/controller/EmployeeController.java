package com.example.employeehqldemo.controller;

import com.example.employeehqldemo.model.Employee;
import com.example.employeehqldemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/permanent")
    public List<Employee> getAllPermanentEmployees() {
        return employeeService.getAllPermanentEmployees();
    }
}
