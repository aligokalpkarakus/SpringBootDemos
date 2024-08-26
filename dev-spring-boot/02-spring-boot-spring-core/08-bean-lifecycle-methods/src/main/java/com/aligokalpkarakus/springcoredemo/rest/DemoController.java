package com.aligokalpkarakus.springcoredemo.rest;

import com.aligokalpkarakus.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Bu sınıfı bir Spring Rest Controller olarak tanımlar.
// Bu, sınıfın HTTP isteklerini işleyebileceği anlamına gelir.
@RestController
public class DemoController {

    // Bağımlılık (dependency) için özel bir alan tanımlar.
    //define a private field for the dependency
    private Coach myCoach;

    /* field injection örneği. Artık pek kullanılmıyor çünkü unit testi zorlaştırıyor.
    @Autowired
    private Coach myCoach;
     */

    /*
    //Setter injection
    @Autowired // Spring'e bu metodun bağımlılık enjeksiyonu için kullanılması gerektiğini söyler.
    public void setCoach(Coach coach) {
        // Metod bağımlılığı özel alana atar.
        myCoach = coach;
    }
     */

    /*
    Burada bean scope'u inceliyoruz. Default scope singleton olduğu için tüm dependency injectionlar
    aynı bean'i referans alacak.
     */
    @Autowired // Spring'e bu yapıcının bağımlılık enjeksiyonu için kullanılmasını söyler.
    public DemoController(@Qualifier("tennisCoach") Coach coach) {

        System.out.println("democontroller");
        myCoach = coach;

    }

    // "/dailyworkout" endpoint'ine HTTP GET isteği geldiğinde bu metodu çalıştırır.
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        // Coach nesnesinin getDailyWorkout() metodunu çağırarak döndürülen değeri döner.
        return myCoach.getDailyWorkout();
    }


}
