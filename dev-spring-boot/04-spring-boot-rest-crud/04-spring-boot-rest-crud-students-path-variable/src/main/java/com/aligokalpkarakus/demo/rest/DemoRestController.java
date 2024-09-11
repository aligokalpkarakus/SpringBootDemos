package com.aligokalpkarakus.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Bu sınıfı bir RESTful denetleyici olarak işaretler, HTTP isteklerine yanıt verir.
@RestController
// "/test" yoluna yapılan istekleri bu sınıfa yönlendirir.
@RequestMapping("/test")
public class DemoRestController {

    // "/hello" yoluna yapılan GET isteklerini işleyen bir yöntem oluşturur.
    @GetMapping("/hello")
    public String hello() {
        // Bu metodun yanıtı "Hello World" string'idir.
        return "Hello World";
    }
}
