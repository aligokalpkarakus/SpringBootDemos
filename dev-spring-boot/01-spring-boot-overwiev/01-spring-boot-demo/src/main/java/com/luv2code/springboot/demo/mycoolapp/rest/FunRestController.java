package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Bu anotasyon, sınıfın bir Spring RESTful web servisi denetleyicisi olduğunu belirtir.
// Sınıfın HTTP isteklerini (GET, POST vb.) karşılayabileceği anlamına gelir
// ve yöntemlerin geri döndürdüğü verilerin doğrudan HTTP yanıtına yazılacağını belirtir.
@RestController
public class FunRestController {

    // Bu anotasyon, HTTP GET isteklerini karşılamak için kullanılan bir yöntem olduğunu belirtir.
    // Buradaki "/" parametresi, bu metodun uygulamanın ana dizinine (/) gelen GET isteklerini
    // karşılayacağını gösterir.
    @GetMapping("/")
    public String sayHello(){
        // Bu satır, sayHello metodunun çağrıldığında "Hello World" dizesini döndüreceğini belirtir.
        return "Hello World";
    }
}
