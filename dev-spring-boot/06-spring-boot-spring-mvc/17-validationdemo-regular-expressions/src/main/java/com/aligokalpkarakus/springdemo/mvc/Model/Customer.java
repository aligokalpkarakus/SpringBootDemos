package com.aligokalpkarakus.springdemo.mvc.Model;

import jakarta.validation.constraints.*;

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

    // PostalCode için doğrulama kuralları:
    // Girilen posta kodunu regular expression'a uygunluğunun kontrolü
    // Sadece 5 karakter kabul edecek ve bu 5 karakter harfleri veya rakamları kabul edecek.
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;

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
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

}
