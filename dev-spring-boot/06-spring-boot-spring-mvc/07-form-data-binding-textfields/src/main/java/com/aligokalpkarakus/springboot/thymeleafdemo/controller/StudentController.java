package com.aligokalpkarakus.springboot.thymeleafdemo.controller;

import com.aligokalpkarakus.springboot.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    // This method handles GET requests for "/showStudentForm"
    // "/showStudentForm" adresine gelen GET isteklerini işler
    @GetMapping("/showStudentForm")
    public String showForm(Model model) {

        // create a student object
        // Yeni bir Student nesnesi oluşturuyoruz. Bu nesne daha sonra formda kullanılacak.
        Student theStudent = new Student();

        // add student object to the model
        // Student nesnesini model objesine ekliyoruz. Bu sayede, Thymeleaf şablonunda kullanılabilir hale geliyor.
        model.addAttribute("student", theStudent);

        // return view name
        // "student-form" adlı Thymeleaf şablonuna yönlendirme yapılıyor. Bu şablonda form gösterilecek.
        return "student-form";
    }

    // Burayı GetMapping yapıp HTML formda da GET metodu yaparak da yapabiliyoruz.
    @PostMapping("/processStudentForm") //HTML formunda kullandığımız ad.
    public String processForm(@ModelAttribute("student") Student theStudent) {

        //log the input data
        System.out.println("Student is : " + theStudent.getFirstName() +" "+ theStudent.getLastName());

        return "student-confirmation";
    }


}
