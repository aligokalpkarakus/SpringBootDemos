package com.aligokalpkarakus.springdemo.mvc.Model;

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

}
