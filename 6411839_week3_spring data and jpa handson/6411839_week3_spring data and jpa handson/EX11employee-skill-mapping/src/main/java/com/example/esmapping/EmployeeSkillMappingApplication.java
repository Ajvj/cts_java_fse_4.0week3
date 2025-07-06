package com.example.esmapping;

import com.example.esmapping.model.Employee;
import com.example.esmapping.model.Skill;
import com.example.esmapping.service.EmployeeService;
import com.example.esmapping.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Set;

@SpringBootApplication
public class EmployeeSkillMappingApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeSkillMappingApplication.class);
    private static EmployeeService employeeService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EmployeeSkillMappingApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        skillService = context.getBean(SkillService.class);


        testAddSkillToEmployee();
    }

    private static void testGetEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Skills: {}", employee.getSkillList());
        LOGGER.info("End");
    }

    private static void testAddSkillToEmployee() {
        LOGGER.info("Start");

        Employee employee = employeeService.get(1); // ✅ Use valid employee ID
        Skill skill = skillService.get(2);           // ✅ Use valid skill ID

        Set<Skill> skillSet = employee.getSkillList();
        skillSet.add(skill);

        employee.setSkillList(skillSet);
        employeeService.save(employee);

        LOGGER.debug("Updated Employee: {}", employee);
        LOGGER.info("End");
    }
}
