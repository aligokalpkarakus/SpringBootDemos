package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees") //base mapping for URL requests
public class EmployeeController {

    private EmployeeService employeeService;

    //Constructor Injection.
    //Since only one constructor, @Autowired is optional.
    public EmployeeController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model) {

        //get the employees from db
        List<Employee> employeeList = employeeService.findAll();

        //add to the spring model
        model.addAttribute("employees", employeeList);

        //return the form
        return "employee-list";

    }
}
