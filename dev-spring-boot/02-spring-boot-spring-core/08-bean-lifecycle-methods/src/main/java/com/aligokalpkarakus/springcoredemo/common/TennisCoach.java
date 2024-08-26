package com.aligokalpkarakus.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

// Bu sınıfı bir Spring Bean olarak işaretler.
// Spring tarafından yönetilen bir bileşen (bean) olmasını sağlar.
@Component
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("TennisCoach");
    }

    // Coach arayüzündeki getDailyWorkout metodunu uyguluyor.
    @Override
    public String getDailyWorkout() {
        // Bu metod, günlük egzersiz olarak "raketin nerede" mesajını döndürür.
        return "raketin nerede";
    }

    @PostConstruct
    // Bu metod, TennisCoach sınıfının bean'i oluşturulduktan sonra otomatik olarak çağrılır.
    // Başlatma işlemlerini yapmak için kullanılır.
    public void init() {
        System.out.println("TennisCoach init");
    }

    @PreDestroy
    // Bu metod, TennisCoach sınıfının bean'i yok edilmeden hemen önce otomatik olarak çağrılır.
    // Temizlik işlemleri yapmak için kullanılır.
    public void destroy() {
        System.out.println("TennisCoach destroy");
    }


}
