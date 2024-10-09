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

    // Add a request mapping for /leaders
    @GetMapping("/leaders")
    public String showLeaders() {
        // Return the view name "leaders" to display the corresponding HTML page for managers
        return "leaders";
    }

    // Add a request mapping for /systems
    @GetMapping("/systems")
    public String showSystems() {
        // Return the view name "systems" to display the corresponding HTML page for admins
        return "systems";
    }

}
