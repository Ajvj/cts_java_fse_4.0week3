package com.example.hqljpqldemo.controller;

import com.example.hqljpqldemo.model.Employee;
import com.example.hqljpqldemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee) {
        service.save(employee);
        return "Employee added!";
    }

    @GetMapping("/department/{dept}")
    public List<Employee> getByDepartment(@PathVariable String dept) {
        return service.getEmployeesByDepartment(dept);
    }

    @GetMapping("/salary/{amount}")
    public List<Employee> getByHighSalary(@PathVariable double amount) {
        return service.getHighSalaryEmployees(amount);
    }
}
