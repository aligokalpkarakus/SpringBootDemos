package com.aligokalpkarakus.springboot.cruddemo.service;

import com.aligokalpkarakus.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    //Employee findById(int id);


}
