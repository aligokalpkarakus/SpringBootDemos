package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    //add a method to sort by last name
    //Spring Data JPA will parse the method name
    //looks for a spesific format and pattern creates appropriate query behind the scenes.
    //findallby ------ orderbylastnameascending
    //buna göre parse edecek.
    //"from Employee order by lastName asc" query'sini oluşturacak.
    public List<Employee> findAllByOrderByLastNameAsc();

}
