package com.aligokalpkarakus.springboot.cruddemo.rest;

import com.aligokalpkarakus.springboot.cruddemo.entity.Employee;
import com.aligokalpkarakus.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST controller to handle API requests
@RequestMapping("/api") // Maps all endpoints to start with /api
public class EmployeeRestController {

    // Define the EmployeeService field to handle business logic
    private EmployeeService employeeService;

    // Inject EmployeeService through constructor-based dependency injection
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // Expose "/employees" endpoint to return a list of employees using EmployeeService
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    // Expose "/employees/{employeeId}" to return an employee by ID
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        // Check if the employee exists, otherwise throw a runtime exception
        if (employee == null) {
            throw new RuntimeException("Employee id not found: " + employeeId);
        }

        return employee;
    }

    // Expose "/employees" endpoint for POST request to add a new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        // If the ID is passed in the JSON, set it to 0 to ensure the save operation creates a new entry
        // In the db, the id is going to be set by itself.
        employee.setId(0);

        // Save the employee using EmployeeService
        Employee savedEmployee = employeeService.save(employee);

        // Return it for the new db
        return savedEmployee;
    }
}
