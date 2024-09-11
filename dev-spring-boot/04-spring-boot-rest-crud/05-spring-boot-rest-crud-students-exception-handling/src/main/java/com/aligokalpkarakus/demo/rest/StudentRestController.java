package com.aligokalpkarakus.demo.rest;

import com.aligokalpkarakus.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // Sınıfı bir RESTful denetleyici olarak işaretler
@RequestMapping("/api") // Bu sınıftaki tüm endpoint'lerin "/api" ile başlamasını sağlar
public class StudentRestController {

    private List<Student> students; // Öğrenci listesini tutan bir alan

    // @PostConstruct anotasyonu ile işaretlenmiş metod, sınıf örneği oluşturulduktan sonra yalnızca bir kez çalışır.
    @PostConstruct
    public void loadData() {
        // Öğrenci listesi oluşturulur
        students = new ArrayList<>();

        // Öğrenciler listeye eklenir
        students.add(new Student("Gökalp", "Karakuş"));
        students.add(new Student("Ali", "Karakuş"));
        students.add(new Student("Selin", "Karakuş"));
    }

    // "/students" endpoint'ini tanımlar ve öğrenci listesini döndürür
    @GetMapping("/students") // HTTP GET isteği ile "/api/students" çağrıldığında bu metod çalışır
    public List<Student> getStudents() {
        /*Bu yorum satırındaki yöntemle her istekte tekrar tekrar liste oluşturuyoruz. Bunu düzeltelim
            // Öğrenci listesi oluşturulur
            List<Student> students = new ArrayList<>();

            // Öğrenciler listeye eklenir
            students.add(new Student("Gökalp", "Karakuş"));
            students.add(new Student("Ali", "Karakuş"));
            students.add(new Student("Selin", "Karakuş"));
         */

        // Öğrenci listesi döndürülür.
        // Jackson, List<Student>'ı bir JSON array'e arka planda otomatik olarak çevirir.
        return students;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    // @PathVariable int studentId, URL'deki {studentId} parametresini alır ve bir metoda argüman olarak aktarır.
    public Student getStudent(@PathVariable int studentId) {
        // Just index into the list

        // Gelen studentId parametresi ile listede bulunan öğrencileri kontrol eder.
        // Eğer öğrenci numarası listenin boyutunu aşarsa veya negatif bir numara girilirse istisna fırlatılır.
        if ((studentId >= students.size()) || (studentId < 0)) {
            // Eğer geçersiz bir id gelirse, custom istisna fırlatılır.
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        // Geçerli bir id ise, listeden ilgili öğrenci döndürülür.
        return students.get(studentId);
    }

    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    //             <Response type for the response body>      (Exception type to handle/catch)
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value()); // HTTP durum kodu olarak 404 Not Found atanır.
        error.setMessage(exc.getMessage()); // İstisnanın mesajı atanır.
        error.setTimeStamp(System.currentTimeMillis()); // Hata zaman damgası atanır.

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // Hata yanıtını HTTP 404 Not Found ile döner.
    }

    // Add another exception handler to catch any exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value()); // HTTP durum kodu olarak 400 Bad Request atanır.
        error.setMessage(exc.getMessage()); // İstisnanın mesajı atanır.
        error.setTimeStamp(System.currentTimeMillis()); // Hata zaman damgası atanır.

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); // Hata yanıtını HTTP 400 Bad Request ile döner.
    }











}

