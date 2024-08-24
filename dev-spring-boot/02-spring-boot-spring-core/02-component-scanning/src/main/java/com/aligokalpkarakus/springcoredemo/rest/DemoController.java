package com.aligokalpkarakus.springcoredemo.rest;

import com.aligokalpkarakus.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Bu sınıfı bir Spring Rest Controller olarak tanımlar.
// Bu, sınıfın HTTP isteklerini işleyebileceği anlamına gelir.
@RestController
public class DemoController {

    // Bağımlılık (dependency) için özel bir alan tanımlar.
    //define a private field for the dependency
    private Coach myCoach;

    //define a constructor for dependency injection
    //If y ou only have one constructor then this annotation is optional
    @Autowired //tells Spring to inject a dependency
    public DemoController(Coach coach) {
        myCoach = coach;
    }

    // "/dailyworkout" endpoint'ine HTTP GET isteği geldiğinde bu metodu çalıştırır.
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        // Coach nesnesinin getDailyWorkout() metodunu çağırarak döndürülen değeri döner.
        return myCoach.getDailyWorkout();
    }
}
