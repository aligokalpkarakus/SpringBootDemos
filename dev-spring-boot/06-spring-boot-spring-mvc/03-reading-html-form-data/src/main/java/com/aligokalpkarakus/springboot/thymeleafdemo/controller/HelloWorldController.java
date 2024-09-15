package com.aligokalpkarakus.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
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

}
