package com.aligokalpkarakus.springboot.cruddemo.service;

import com.aligokalpkarakus.springboot.cruddemo.dao.EmployeeRepository;
import com.aligokalpkarakus.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a service layer component to handle business logic
public class EmployeeServiceImpl implements EmployeeService {

    /* We are using EmployeeRepository from now on. Which has JpaRepository. So we do not this anymore.
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
     */

    private EmployeeRepository employeeRepository;

    // Constructor-based dependency injection using @Autowired
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        // Delegate the call to DAO to fetch all employees
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        // Verilen ID'ye göre bir çalışan bulmaya çalışır. Sonuç bir Optional<Employee> döner
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee employee = null;

        // Eğer Optional içinde değer varsa (çalışan bulunduysa), çalışan nesnesini alır
        if(result.isPresent()) {
            employee = result.get(); // Optional içindeki çalışan nesnesini alır
        } else {
            // Eğer çalışan bulunamazsa, bir istisna fırlatır
            throw new RuntimeException("Employee not found id:" + theId);
        }

        // Bulunan çalışan nesnesini döndürür
        return employee;
    }


    @Override
    //JpaRepository handles Transactional functionality by itself. So we do not need to add this annotation.
    //@Transactional //to ensure that any database changes they perform happen within a single transaction, ensuring consistency.
    public Employee save(Employee employee) {
        // Delegate the call to DAO to save or update an employee
        return employeeRepository.save(employee);
    }

    @Override
    //JpaRepository handles Transactional functionality by itself. So we do not need to add this annotation.
    //@Transactional //to ensure that any database changes they perform happen within a single transaction, ensuring consistency.
    public void deleteById(int theId) {
        // Delegate the call to DAO to delete an employee by id
        employeeRepository.deleteById(theId);
    }
}
