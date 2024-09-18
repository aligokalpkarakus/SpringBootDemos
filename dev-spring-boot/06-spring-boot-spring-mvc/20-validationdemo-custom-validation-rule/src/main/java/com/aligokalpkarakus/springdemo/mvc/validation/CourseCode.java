package com.aligokalpkarakus.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Yardımcı sınıf: İş kurallarını ve doğrulama mantığını içerir.
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
// 'CourseCodeConstraintValidato' sınıfı doğrulama işlemini gerçekleştirecek sınıftır.

// Bu anotasyonun hangi alanlarda kullanılabileceğini belirliyoruz.
// Burada metodlara ve alanlara uygulanabileceğini belirtiyoruz.
@Target({ElementType.FIELD, ElementType.METHOD})

// @Retention, işaretlenen ek açıklama ne kadar süreyle saklanacak veya kullanılacak bunun cevabını ister.
// Anotasyonun çalışma zamanında mı, yoksa sadece derleme zamanında mı kullanılacağını belirler.
// Temel olarak bu ek açıklamayı bytecode'da saklayın, ayrıca JVM tarafından çalışma zamanında kullanın diyoruz.
// 'RUNTIME' seçeneği ile çalışma zamanında da kullanılır olmasını sağlıyoruz.
@Retention(RetentionPolicy.RUNTIME)

//Custom anotasyonumuz. Girilen kurs kodunun başında belli bir String'in olup olmamasına göre geri dönüş verecek.
public @interface CourseCode {

    // define default course code
    public String value() default "GOKALP";

    // define default error message
    public String message() default "must start with GOKALP";

    // Gruplama işlemi için bir alan tanımlanır. Doğrulama kısıtlamalarını gruplayabiliriz.
    // Burada bu özelliği kullanmayacağız, bu yüzden boş bırakıyoruz.
    public Class<?>[] groups() default {};

    // Doğrulama hatası hakkında ek bilgi sağlamak için payload alanı tanımlanır.
    // Bu genellikle hatanın şiddet seviyesi veya hata kodu gibi bilgiler içerebilir.
    // Şu an için kullanmadığımızdan, boş bırakıyoruz.
    public Class<? extends Payload>[] payload() default {};


}
