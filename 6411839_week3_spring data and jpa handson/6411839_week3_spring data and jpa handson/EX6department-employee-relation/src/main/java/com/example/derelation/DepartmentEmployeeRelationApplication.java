package com.example.derelation;

import com.example.derelation.model.Department;
import com.example.derelation.model.Employee;
import com.example.derelation.service.DepartmentService;
import com.example.derelation.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DepartmentEmployeeRelationApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentEmployeeRelationApplication.class);
    private static DepartmentService departmentService;
    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DepartmentEmployeeRelationApplication.class, args);
        departmentService = context.getBean(DepartmentService.class);
        employeeService = context.getBean(EmployeeService.class);

         testGetDepartment();
    }

    private static void testGetDepartment() {
        LOGGER.info("Start");

        Department department = departmentService.get(1);
        LOGGER.debug("Department: {}", department);
        LOGGER.debug("Employees: {}", department.getEmployeeList());

        LOGGER.info("End");
    }
}
