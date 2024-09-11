package com.aligokalpkarakus.demo.rest;

import com.aligokalpkarakus.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // Sınıfı bir RESTful denetleyici olarak işaretler
@RequestMapping("/api") // Bu sınıftaki tüm endpoint'lerin "/api" ile başlamasını sağlar
public class StudentRestController {

    private List<Student> students;

    //define @PostConstruct to load the student data.. only once!
    @PostConstruct
    public void loadData(){
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
}

