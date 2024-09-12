package com.aligokalpkarakus.springboot.cruddemo.dao;

import com.aligokalpkarakus.springboot.cruddemo.entity.Employee;

import java.util.List;

// Employee Data Access Object (DAO) interface for handling database operations
public interface EmployeeDAO {

    // Method to retrieve a list of employees from the database
    List<Employee> findAll();
}
