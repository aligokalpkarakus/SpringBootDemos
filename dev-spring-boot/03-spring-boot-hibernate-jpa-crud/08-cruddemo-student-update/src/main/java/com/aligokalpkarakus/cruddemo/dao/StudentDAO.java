package com.aligokalpkarakus.cruddemo.dao;

import com.aligokalpkarakus.cruddemo.entity.Student;

import java.util.List;

// StudentDAO interface'i, Student entity'si üzerinde yapılacak veritabanı işlemleri için bir şablon sağlar.
public interface StudentDAO {

    // Öğrenci kaydetme işlemi için bir method tanımlanır.
    void save(Student student); // Öğrenci nesnesini veritabanına kaydedecek olan method.

    // Öğrenciyi verilen id ile veritabanından bulmayı sağlayan method.
    Student findById(int id); // Verilen id'ye sahip öğrenciyi bulur ve döner.

    // Tüm öğrencileri veritabanında bulmayı sağlayan method
    List<Student> findAll();

    // Öğrencileri soyadına göre veritabanından bulmayı sağlayan method
    List<Student> findByLastName(String theLastName);

    // ID ile belirtilen öğrenciyi veritabanında güncellemek için method.
    void update(Student student);
}
