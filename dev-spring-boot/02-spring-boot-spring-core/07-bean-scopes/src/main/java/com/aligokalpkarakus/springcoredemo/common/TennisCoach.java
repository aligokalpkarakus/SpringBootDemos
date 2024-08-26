package com.aligokalpkarakus.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Bu sınıfı bir Spring Bean olarak işaretler.
// Spring tarafından yönetilen bir bileşen (bean) olmasını sağlar.
@Component
//Default scope singleton olduğu için tüm dependency injectionlar
//aynı bean'i referans alacak. Eğer amacımız bir tane instance değil de farklı bir instance daha üretmek ise
//default olan singleton'ı prototype yaparız.
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
