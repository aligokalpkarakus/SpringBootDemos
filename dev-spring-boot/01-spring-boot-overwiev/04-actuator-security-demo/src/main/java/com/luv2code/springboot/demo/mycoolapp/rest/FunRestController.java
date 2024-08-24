package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Bu sınıf bir RESTful web servisi denetleyicisi olarak tanımlanmıştır.
// Sınıf, HTTP isteklerini (GET, POST vb.) karşılayabilir ve yöntemlerin geri döndürdüğü
// veriler doğrudan HTTP yanıtına yazılır.
@RestController
public class FunRestController {

    // Ana dizine ("/") gelen GET isteklerini karşılayacak bir metot oluşturuluyor.
    // Bu metot, "Hello World" mesajını döndürür.
    @GetMapping("/")
    public String sayHello(){
        // Bu satır, sayHello metodunun çağrıldığında "Hello World" dizesini döndüreceğini belirtir.
        return "Hello World";
    }

    // Yeni bir endpoint (uç nokta) tanımlar: "/workout"
    // Bu anotasyon, "/workout" adresine gelen HTTP GET isteklerini karşılar.
    @GetMapping("/workout")
    public String workout(){
        // Bu satır, workout metodunun çağrıldığında "Run a hard 5k!" dizesini döndüreceğini belirtir.
        return "Run a hard 5k!";
    }

    // Yeni bir endpoint (uç nokta) tanımlar: "/fortune"
    // Bu anotasyon, "/fortune" adresine gelen HTTP GET isteklerini karşılar.
    @GetMapping("/fortune")
    public String getDailyFortune(){
        // Bu satır, getDailyFortune metodunun çağrıldığında "Today is your lucky day." dizesini döndüreceğini belirtir.
        return "Today is your lucky day.";
    }

}






