package com.aligokalpkarakus.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    //Request mapping, o uzantılarda istekleri verileri tutar, yerleştirir, aktarır.

    // controller method to show initial HTML form
    @RequestMapping("/showForm")
    public String showForm(){

        //src/main/resources/templates/helloworld-form.html
        return "helloworld-form";
    }

    // controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        //src/main/resources/templates/helloworld-process.html
        return "helloworld-process";
    }

    // Controller method to read form data and add data to the model
    @RequestMapping("/processFormVerTwo")
    public String processFormVerTwo(HttpServletRequest request, Model model){
        // HttpServletRequest request: Bu parametre, gelen HTTP isteğiyle birlikte gönderilen form verilerini
        // okumak için kullanılır.

        // Read the request parameter from the HTML form
        // HTML formunda 'studentName' adlı input alanına girilen değeri request'ten alıyoruz.
        String theName = request.getParameter("studentName");

        // Convert the data to all caps
        // Alınan ismi büyük harfe çeviriyoruz.
        theName = theName.toUpperCase();

        // Create the message
        // Kullanıcının ismini içeren bir mesaj oluşturuyoruz.
        String result = "Yo! " + theName;

        // Add message to the model
        // Mesajı modele ekleyerek Thymeleaf tarafından kullanılmasını sağlıyoruz.
        model.addAttribute("message", result);

        // "helloworld-process" adındaki Thymeleaf sayfasına yönlendiriyoruz.
        return "helloworld-process";
    }


}
