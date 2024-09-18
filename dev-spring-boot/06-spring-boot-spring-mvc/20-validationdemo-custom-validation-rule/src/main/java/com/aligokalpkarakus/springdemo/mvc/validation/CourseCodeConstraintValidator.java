package com.aligokalpkarakus.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// Bu sınıf, CourseCode anotasyonunun doğrulama mantığını içerir ve CourseCode anotasyonu için validator görevi görür.
// İkinci parametre String: Bu doğrulayıcıyı, String türündeki alanlarda kullanabileceğimizi belirtir.
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    // Kullanıcı tarafından girilen kurs kodunun başlangıcında olması gereken prefix'i tutan değişken.
    private String coursePrefix;

    // Bu metot, CourseCode anotasyonunun value'sunu alır ve coursePrefix'e atar.
    // Yani, CourseCode anotasyonu kullanılınca ilk olarak bu metot çağrılır ve ilgili prefix atanır.
    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value(); // Anotasyondaki 'value' değeri coursePrefix olarak atanır.
    }

    // Bu metot validasyonun ana mantığını içerir. Burada theCode, HTML formundan kullanıcı tarafından girilen veriyi temsil eder.
    // constraintValidatorContext, doğrulama bağlamını tutar ve ek hata mesajları sağlamada kullanabiliriz.
    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;

        // Kullanıcı girişi null ise ya da boş bir dize ise, bu durumda false döndürüyoruz (yani geçersiz).
        if (theCode != null) {
            // Kullanıcı tarafından girilen kurs kodu, coursePrefix ile kontrol ediliyor. Dönen bool result'a geçiyor.
            result = theCode.startsWith(coursePrefix); // true mu false mu sonucu döndürüyoruz.
        } else {
            // Derste instructor burayı true olarak ayarladı, yani null ise direkt processForm'a geçişte sıkıntı yok.
            // ama ben error mesajını döndürmeyi doğru buluyorum
            result = false; // theCode null ise, false olarak döndürüyoruz.
        }

        return result;
    }
}

