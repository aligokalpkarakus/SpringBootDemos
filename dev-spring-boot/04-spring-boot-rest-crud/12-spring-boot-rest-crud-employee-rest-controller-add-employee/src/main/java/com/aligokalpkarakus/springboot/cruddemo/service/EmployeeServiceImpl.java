package com.aligokalpkarakus.springboot.cruddemo.service;

import com.aligokalpkarakus.springboot.cruddemo.dao.EmployeeDAO;
import com.aligokalpkarakus.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marks this class as a service layer component to handle business logic
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    // Constructor-based dependency injection using @Autowired
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        // Delegate the call to DAO to fetch all employees
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        // Delegate the call to DAO to fetch employee by id
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional //to ensure that any database changes they perform happen within a single transaction, ensuring consistency.
    public Employee save(Employee employee) {
        // Delegate the call to DAO to save or update an employee
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional //to ensure that any database changes they perform happen within a single transaction, ensuring consistency.
    public void deleteById(int theId) {
        // Delegate the call to DAO to delete an employee by id
        employeeDAO.deleteById(theId);
    }
}
