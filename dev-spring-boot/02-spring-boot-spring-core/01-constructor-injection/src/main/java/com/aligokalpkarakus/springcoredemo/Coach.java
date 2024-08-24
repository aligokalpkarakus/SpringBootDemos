package com.aligokalpkarakus.springcoredemo;

// Coach arayüzü tanımlanır.
// Bu arayüz, koç sınıfları için bir şablon görevi görür ve bir günlük egzersiz almanın yolu olarak hizmet eder.
public interface Coach {

    // Günlük egzersiz bilgilerini döndüren bir metod tanımlanır.
    // Bu metod, her bir Coach implementasyonu için günlük egzersiz görevlerini tanımlar.
    String getDailyWorkout();
}
