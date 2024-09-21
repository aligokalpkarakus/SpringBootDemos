package com.aligokalpkarakus.springboot.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Bu sınıfın bir Spring MVC controller'ı olduğunu belirtir.
public class CompanyController {

    // Ana sayfayı göstermek için bir GET isteğini yakalar.
    @GetMapping("/") // URL'deki "/" (ana yol) ile eşleşen HTTP GET isteklerini işler.
    public String showHome() {
        // "home" isimli HTML dosyasını döndürür, bu Thymeleaf veya başka bir görünüm çözümleyici tarafından işlenecek.
        return "home";
    }
}
