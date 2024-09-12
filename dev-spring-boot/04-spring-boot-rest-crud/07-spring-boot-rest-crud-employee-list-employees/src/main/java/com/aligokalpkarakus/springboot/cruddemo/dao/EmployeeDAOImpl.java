package com.aligokalpkarakus.springboot.cruddemo.dao;

import com.aligokalpkarakus.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Marks the class as a DAO component to handle database interactions
public class EmployeeDAOImpl implements EmployeeDAO {

    // Field for the EntityManager to handle database operations
    private EntityManager entityManager;

    // Constructor for EntityManager, injected using @Autowired annotation
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> getEmployeeList() {
        // Create a TypedQuery to fetch Employee entities
        TypedQuery<Employee> employeeListQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // Execute the query and get the result list
        List<Employee> employeeList = employeeListQuery.getResultList();

        // Return the list of employees
        return employeeList;
    }
}
