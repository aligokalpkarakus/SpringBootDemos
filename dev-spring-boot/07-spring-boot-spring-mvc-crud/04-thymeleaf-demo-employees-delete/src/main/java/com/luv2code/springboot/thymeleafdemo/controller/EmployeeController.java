package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    //alternatif butonları kullanırsak HTML metodunu POST verdiğimiz için PostMapping kullanmalıyız.
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {
        //@RequestParam("employeeId") int theId: URL'deki employeeId parametresini alır ve theId değişkenine atar.
        //Örneğin, /showFormForUpdate?employeeId=1 çağrıldığında, theId = 1 olur.

        //get the employee from the service.
        Employee employee = employeeService.findById(theId);

        //set employee in the model to prepopulate the form.
        model.addAttribute("employee", employee);

        //send over to our form.
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

    //alternatif butonları kullanırsak HTML metodunu POST verdiğimiz için PostMapping kullanmalıyız.
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId) {
        //@RequestParam("employeeId") int theId: URL'deki employeeId parametresini alır ve theId değişkenine atar.
        //Örneğin, /delete?employeeId=1 çağrıldığında, theId = 1 olur.

        // Çalışanı ID'sine göre siler.
        employeeService.deleteById(theId);

        // Silme işlemi tamamlandıktan sonra çalışan listesini görüntülemek üzere yeniden yönlendirir.
        return "redirect:/employees/list";
    }

}
