package com.aligokalpkarakus.springboot.cruddemo.dao;

import com.aligokalpkarakus.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Marks the class as a DAO component to handle database interactions
public class EmployeeDAOImpl implements EmployeeDAO {

    // No need for @Transactional here since transaction management is handled in the service layer.

    // Field for the EntityManager to handle database operations
    private EntityManager entityManager;

    // Constructor for EntityManager, injected using @Autowired annotation
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    // Fetch all employees from the database
    @Override
    public List<Employee> findAll() {
        // Create a TypedQuery to fetch Employee entities
        TypedQuery<Employee> employeeListQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // Execute the query and get the result list
        List<Employee> employeeList = employeeListQuery.getResultList();

        // Return the list of employees
        return employeeList;
    }

    // Find an employee by their ID
    @Override
    public Employee findById(int theId) {

        // Fetch employee by ID using EntityManager
        Employee employee = entityManager.find(Employee.class, theId);

        // return the employee
        return employee;
    }

    // Save or update an employee
    @Override
    public Employee save(Employee employee) {
        // Use merge to handle both insert and update; it saves if the id is 0 (new), updates if it's not.
        Employee savedEmployee = entityManager.merge(employee);

        // Return the updated or newly saved employee.
        return savedEmployee;
    }

    // Delete an employee by their ID
    @Override
    public void deleteById(int theId) {
        // Find the employee to delete by ID
        Employee employee = entityManager.find(Employee.class, theId);

        // Remove the employee from the database
        entityManager.remove(employee);
    }
}
