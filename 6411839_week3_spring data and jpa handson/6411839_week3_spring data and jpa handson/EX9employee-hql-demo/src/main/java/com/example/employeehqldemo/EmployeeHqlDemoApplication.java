package com.example.employeehqldemo;

import com.example.employeehqldemo.model.*;
import com.example.employeehqldemo.repository.DepartmentRepository;
import com.example.employeehqldemo.repository.EmployeeRepository;
import com.example.employeehqldemo.repository.SkillRepository;
import com.example.employeehqldemo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class EmployeeHqlDemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeHqlDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EmployeeHqlDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository empRepo,
                                  DepartmentRepository deptRepo,
                                  SkillRepository skillRepo,
                                  EmployeeService service) {
        return args -> {
            // Save Departments first
            Department d1 = deptRepo.save(new Department(null, "IT"));
            Department d2 = deptRepo.save(new Department(null, "HR"));

            // Save Skills first
            Skill s1 = skillRepo.save(new Skill(null, "Java"));
            Skill s2 = skillRepo.save(new Skill(null, "SQL"));
            Skill s3 = skillRepo.save(new Skill(null, "Python"));

            // Save Employees with linked Department and Skills
            empRepo.save(new Employee(null, "Ajay", 75000, true,
                    LocalDate.of(1998, 5, 10), d1, List.of(s1, s2)));

            empRepo.save(new Employee(null, "John", 65000, false,
                    LocalDate.of(1995, 3, 12), d2, List.of(s2)));

            empRepo.save(new Employee(null, "Priya", 82000, true,
                    LocalDate.of(1997, 8, 22), d1, List.of(s1, s3)));

            // Call test method
            testGetAllPermanentEmployees(service);
        };
    }

    public static void testGetAllPermanentEmployees(EmployeeService employeeService) {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees: {}", employees);
        employees.forEach(e -> LOGGER.debug("Skills of {}: {}", e.getName(), e.getSkillList()));
        LOGGER.info("End");
    }
}
