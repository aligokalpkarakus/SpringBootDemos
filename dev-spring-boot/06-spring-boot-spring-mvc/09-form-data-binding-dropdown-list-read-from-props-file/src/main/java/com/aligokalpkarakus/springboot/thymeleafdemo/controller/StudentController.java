package com.aligokalpkarakus.springboot.thymeleafdemo.controller;

import com.aligokalpkarakus.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    /*
     Drop down list'te ülkeleri göstermeyi bir liste aracılığıyla yapmak istiyoruz.
     Listenin elemanlarını application.properties'de verdik. App properties'den bu elemanları bu listeye
     inject edeceğiz. Orada "countries" adlı değişkenimize vermiştik ülkeleri. Bu yüzden anotasyonda da onu veriyoruz
    */
    @Value("${countries}")
    private List<String> countries;


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

        // Countries listemizi modele yüklüyoruz.
        model.addAttribute("countries", countries);

        // return view name
        // "student-form" adlı Thymeleaf şablonuna yönlendirme yapılıyor. Bu şablonda form gösterilecek.
        return "student-form";
    }

    // Burayı GetMapping yapıp HTML formda da GET metodu yaparak da yapabiliyoruz.
    @PostMapping("/processStudentForm") //HTML formunda kullandığımız ad.
    public String processForm(@ModelAttribute("student") Student theStudent) {

        //log the input data
        System.out.println("Student is : " + theStudent.getFirstName() +" "+ theStudent.getLastName() +
                "From : " + theStudent.getCountry());

        return "student-confirmation";
    }


}
