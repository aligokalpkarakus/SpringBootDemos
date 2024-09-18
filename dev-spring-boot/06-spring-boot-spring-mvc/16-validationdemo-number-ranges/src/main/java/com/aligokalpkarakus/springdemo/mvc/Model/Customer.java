package com.aligokalpkarakus.springdemo.mvc.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

    // Müşterinin adı (doğrulama kuralı yok)
    private String firstName;

    // Soyad için doğrulama kuralları:
    // @NotNull: Soyad boş bırakılamaz.
    // @Size(min = 1): Soyad en az 1 karakter olmalı (boş girişlere izin verilmez).
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    // FreePasses için doğrulama kuralları:
    // Girilen sayı en az 0, en fazla 10 olmalı.
    @Min(value = 0, message = "must be greater than or equal to 0")
    @Max(value = 10, message = "must be less than or equal to 10")
    private int freePasses;

    public Customer() {}

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getFreePasses() {
        return freePasses;
    }
    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

}
