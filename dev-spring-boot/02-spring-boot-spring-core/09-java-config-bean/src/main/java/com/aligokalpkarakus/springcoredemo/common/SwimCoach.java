package com.aligokalpkarakus.springcoredemo.common;

//Bu class'ın diğer coach classlardan farkı @Component'i yok.
//Bu class'ı kullanabilmek için SportConfig class'ını oluşturduk.

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("SwimCoach");
    }

    @Override
    public String getDailyWorkout() {
        return "gözlüğünü getirdin mi";
    }

}
