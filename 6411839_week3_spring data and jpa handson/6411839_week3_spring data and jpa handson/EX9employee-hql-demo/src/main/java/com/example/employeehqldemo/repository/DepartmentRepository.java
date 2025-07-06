package com.example.employeehqldemo.repository;

import com.example.employeehqldemo.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
