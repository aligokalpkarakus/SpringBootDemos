package com.aligokalpkarakus.springboot.cruddemo.service;

import com.aligokalpkarakus.springboot.cruddemo.dao.EmployeeDAO;
import com.aligokalpkarakus.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marks this class as a service layer component
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
}
