package com.example.hqljpqldemo.repository;

import com.example.hqljpqldemo.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    // JPQL Example
    @Query("SELECT e FROM Employee e WHERE e.department = ?1")
    List<Employee> findByDepartmentJPQL(String department);

    // HQL Example
    @Query(value = "SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> findEmployeesWithSalaryGreaterThan(double salary);
}
