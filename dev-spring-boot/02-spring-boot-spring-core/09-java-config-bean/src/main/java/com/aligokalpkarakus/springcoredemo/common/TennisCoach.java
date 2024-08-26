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

}
