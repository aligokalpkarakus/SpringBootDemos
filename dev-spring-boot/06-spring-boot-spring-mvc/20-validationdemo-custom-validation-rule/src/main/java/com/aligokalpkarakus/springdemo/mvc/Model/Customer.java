package com.aligokalpkarakus.springdemo.mvc.Model;

import com.aligokalpkarakus.springdemo.mvc.validation.CourseCode;
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
    // @NotNull: freePasses boş bırakılamaz.
    @Min(value = 0, message = "must be greater than or equal to 0")
    @Max(value = 10, message = "must be less than or equal to 10")
    @NotNull(message = "is required")
    // int'ten Integer'e çevirdik tipi. Çünkü:
    // Input boş girildiyse veya boşluk içeriyorsa stringTrimmerEditor kullanılarak alan düzeltilecek.
    /*
    int: İlkel (primitive) bir veri tipidir ve varsayılan değeri 0'dır. Yani int tipi null olamaz.
    Eğer kullanıcı bir değer girmezse veya boş bırakırsa, bu alan varsayılan olarak 0 değerini alır.
    Integer: Nesne tipi bir sınıftır ve null değeri alabilir. Eğer kullanıcı bir şey girmezse, bu alan null olabilir.
     */
    // Null döndüreceği için problem oluşturuyordu. Null dönünce int hata verdiği için Integer yaptık. Çünkü int tipi
    // null değerini desteklemiyorken Integer destekliyor.
    private Integer freePasses;

    // PostalCode için doğrulama kuralları:
    // Girilen posta kodunu regular expression'a uygunluğunun kontrolü
    // Sadece 5 karakter kabul edecek ve bu 5 karakter harfleri veya rakamları kabul edecek.
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;

    @CourseCode
    //CourseCode(value=.., message=..) yapmadık çünkü default değerlerimizi vermiştik.
    //Default değerler--> value: "GOKALP", message = "must start with GOKALP"
    //Şöyle değerler vererek CourseCode'umuzu defaulttan değiştirebiliriz:
    //@CourseCode(value="TOPS", message="must start with TOPS")
    //Bu durumda değerler--> value: "TOPS", message = "must start with TOPS"
    private String courseCode;

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
    public Integer getFreePasses() {
        return freePasses;
    }
    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

}
