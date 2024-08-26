package com.aligokalpkarakus.springcoredemo.common;

import org.springframework.stereotype.Component;

// Bu sınıfı bir Spring Bean olarak işaretler.
// Spring tarafından yönetilen bir bileşen (bean) olmasını sağlar.
@Component //marks the class as a Spring Bean
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("Cricket Coach");
    }

    // Coach arayüzündeki getDailyWorkout metodunu uyguluyor.
    // Bu anotasyon, bu metodun bir üst sınıf veya arayüzde tanımlanmış bir metodu
    // geçersiz kıldığını belirtir. Derleme sırasında bir hata verilmesini sağlar.
    // Bu şekilde, hataların önlenmesine yardımcı olur ve kodun sürdürülebilirliğini artırır.
    @Override
    public String getDailyWorkout() {
        // Bu metod, günlük egzersiz olarak "Cricketini unutmuşsun" mesajını döndürür.
        return "Cricketini unutmuşsun";
    }
}
