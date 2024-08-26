package com.aligokalpkarakus.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// Bu sınıfı bir Spring Bean olarak işaretler.
// Spring tarafından yönetilen bir bileşen (bean) olmasını sağlar.
@Component
@Lazy // Bean'in yalnızca ihtiyaç duyulduğunda (lazy) başlatılmasını sağlar.
public class TrackCoach implements Coach {

    // Yapıcı (constructor) metod.
    public TrackCoach() {
        // Bu yapıcı çağrıldığında "Track Coach" mesajını konsola yazdırır.
        System.out.println("Track Coach");
    }

    // Coach arayüzündeki getDailyWorkout metodunu uygular.
    @Override
    public String getDailyWorkout() {
        // Bu metod, günlük egzersiz olarak "kundurayla mı koşacan" mesajını döndürür.
        return "kundurayla mı koşacan";
    }

}
