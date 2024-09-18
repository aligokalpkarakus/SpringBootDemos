package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        return "employees/employee-list";

    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        //create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        //return the form
        return "employees/employee-form";
    }

    @PostMapping("/save")          //form data passed in here.
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

        //save the employee
        employeeService.save(theEmployee);

        //use a redirect to prevent duplicate submissions
        //kullanıcı yeniden yükleye basarsa bu yinelenen gönderimleri önlemek istiyoruz.
        //bu Post/Redirect/Get patterndir.
        return "redirect:/employees/list";

    }
}
