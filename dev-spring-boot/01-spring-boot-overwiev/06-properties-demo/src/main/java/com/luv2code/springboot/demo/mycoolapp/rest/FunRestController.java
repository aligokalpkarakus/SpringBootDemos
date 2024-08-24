package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Bu sınıf bir RESTful web servisi denetleyicisi olarak tanımlanmıştır.
// Sınıf, HTTP isteklerini (GET, POST vb.) karşılayabilir ve yöntemlerin geri döndürdüğü
// veriler doğrudan HTTP yanıtına yazılır.
@RestController
public class FunRestController {

    //  inject properties for: coach.name and team.name
    // application.properties'deki ozellikleri enjeksiyon yapar: "coach.name" ve "team.name"

    // "coach.name" özelliğinin değerini coachName değişkenine enjekte eder.
    @Value("${coach.name}")
    private String coachName;
    // "team.name" özelliğinin değerini teamName değişkenine enjekte eder.
    @Value("${team.name}")
    private String teamName;

    // "/teaminfo" endpoint'i için bir HTTP GET isteği tanımlar.
    // Bu metod, "teaminfo" URL'sine gelen GET isteklerini karşılar.
    // expose new endpoint for "teaminfo"
    @GetMapping("/teaminfo")
    public String teamInfo() {
        // Bu satır, "Coach: " ve "Team: " ifadelerini, coachName ve teamName değişkenlerinin değerleriyle birlikte döndürür.
        // Sonuç olarak, koçun ve takımın adını içeren bir String döner.
        return "Coach: " + coachName + "\n" + "Team: " + teamName;
    }

    // Ana dizine ("/") gelen GET isteklerini karşılayacak bir metot oluşturuluyor.
    // Bu metot, "Hello World" mesajını döndürür.
    // expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        // Bu satır, sayHello metodunun çağrıldığında "Hello World" dizesini döndüreceğini belirtir.
        return "Hello World";
    }

    // Yeni bir endpoint (uç nokta) tanımlar: "/workout"
    // Bu anotasyon, "/workout" adresine gelen HTTP GET isteklerini karşılar.
    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String workout(){
        // Bu satır, workout metodunun çağrıldığında "Run a hard 5k!" dizesini döndüreceğini belirtir.
        return "Run a hard 5k!";
    }

    // Yeni bir endpoint (uç nokta) tanımlar: "/fortune"
    // Bu anotasyon, "/fortune" adresine gelen HTTP GET isteklerini karşılar.
    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune(){
        // Bu satır, getDailyFortune metodunun çağrıldığında "Today is your lucky day." dizesini döndüreceğini belirtir.
        return "Today is your lucky day.";
    }

}






