package com.aligokalpkarakus.springboot.cruddemo.dao;

import com.aligokalpkarakus.springboot.cruddemo.entity.Employee;

import java.util.List;

// Employee Data Access Object (DAO) interface for handling database operations
public interface EmployeeDAO {

    // Method to retrieve a list of employees from the database
    List<Employee> findAll();

    // Method to find an employee by their ID
    Employee findById(int theId);

    // Method to save or update an employee in the database
    Employee save(Employee employee);

    // Method to delete an employee by their ID
    void deleteById(int theId);
}
