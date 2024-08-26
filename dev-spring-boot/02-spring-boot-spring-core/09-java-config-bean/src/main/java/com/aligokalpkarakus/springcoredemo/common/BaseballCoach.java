package com.aligokalpkarakus.springcoredemo.common;

import org.springframework.stereotype.Component;

// Bu sınıfı bir Spring Bean olarak işaretler.
// Spring tarafından yönetilen bir bileşen (bean) olmasını sağlar.
@Component
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("BaseballCoach");
    }

    // Coach arayüzündeki getDailyWorkout metodunu uyguluyor.
    @Override
    public String getDailyWorkout() {
        // Bu metod, günlük egzersiz olarak "beyzbol sopan yok" mesajını döndürür.
        return "beyzbol sopan yok";
    }
}
