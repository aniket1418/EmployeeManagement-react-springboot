package com.spring.employeemanagement.repository;

import com.spring.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //all crud databases methods
}
