package com.example.edmapping;

import com.example.edmapping.model.Department;
import com.example.edmapping.model.Employee;
import com.example.edmapping.service.DepartmentService;
import com.example.edmapping.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class EmployeedepartmentmappingApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeedepartmentmappingApplication.class);
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EmployeedepartmentmappingApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);

        // testAddEmployee();
        // testGetEmployee();
        // testUpdateEmployee();
    }

    private static void testAddEmployee() {
        LOGGER.info("Start");

        Employee employee = new Employee();
        employee.setName("Ajay Kumar");
        employee.setSalary(65000);
        employee.setPermanent(true);
        employee.setDateOfBirth(LocalDate.of(1999, 12, 25));

        Department dept = departmentService.get(1);
        employee.setDepartment(dept);

        employeeService.save(employee);
        LOGGER.debug("Employee Saved: {}", employee);

        LOGGER.info("End");
    }

    private static void testGetEmployee() {
        LOGGER.info("Start");

        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Department: {}", employee.getDepartment());

        LOGGER.info("End");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start");

        Employee employee = employeeService.get(1);
        Department newDept = departmentService.get(2);
        employee.setDepartment(newDept);

        employeeService.save(employee);
        LOGGER.debug("Employee Updated: {}", employee);

        LOGGER.info("End");
    }
}
