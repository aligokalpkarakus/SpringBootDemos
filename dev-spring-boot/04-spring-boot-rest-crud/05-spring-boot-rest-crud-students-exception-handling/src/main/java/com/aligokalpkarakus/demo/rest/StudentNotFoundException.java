package com.aligokalpkarakus.demo.rest;

// Bu sınıf, belirli bir öğrenci bulunamadığında fırlatılan özel bir istisnadır (RuntimeException'dan türetilmiştir).
public class StudentNotFoundException extends RuntimeException {

    // Tek parametreli yapıcı: Hata mesajını alır ve üst sınıfa (RuntimeException) iletir.
    public StudentNotFoundException(String message) {
        super(message); // Gelen hata mesajı üst sınıfın yapıcısına gönderilir.
    }

    // Hata mesajı ve nedenini alır, her ikisini de üst sınıfa iletir.
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause); // Mesaj ve neden üst sınıfa iletilir.
    }

    // Yalnızca hatanın nedenini alır ve üst sınıfa iletir.
    public StudentNotFoundException(Throwable cause) {
        super(cause); // Hatanın nedeni üst sınıfa iletilir.
    }
}
