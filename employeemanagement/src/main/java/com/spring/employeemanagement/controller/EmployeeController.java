package com.spring.employeemanagement.controller;

import com.spring.employeemanagement.exception.ResourceNotFoundException;
import com.spring.employeemanagement.model.Employee;
import com.spring.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping()
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @PostMapping()
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //Get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeesById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist"));
        return ResponseEntity.ok(employee);
    }

    //update employee REST api
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist"));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());
        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }
}
