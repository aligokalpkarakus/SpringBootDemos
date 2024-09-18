package com.aligokalpkarakus.springdemo.mvc.controller;

import com.aligokalpkarakus.springdemo.mvc.Model.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String showForm(Model model) {

        model.addAttribute("customer", new Customer());

        return "customer-form";

    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult) {
        //@Valid tell spring MVC to perform validation.
        //@ModelAttribute ile geçen customer objesi, @Valid ile belirlenen validation kurallarına
        //(@NotNull, @Size) göre doğrulama yapar.
        //BindingResult, @Valid anotasyonunun doğrulaması hakkındaki sonucu taşır. Yani @Valid'den
        //ne döndüyse bunu bindingResult'ta bulacağız.

        if (bindingResult.hasErrors()) {
            //bindingResult'taki cevapta hata var bilgisi varsa customer-form'a geri dönülecek.
            return "customer-form";
        }else{
            //hata yoksa customer-confirmation'a geçilecek.
            return "customer-confirmation";
        }

    }

}
