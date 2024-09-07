package com.aligokalpkarakus.cruddemo.dao;

import com.aligokalpkarakus.cruddemo.entity.Student;

// StudentDAO interface'i, Student entity'si üzerinde yapılacak veritabanı işlemleri için bir şablon sağlar.
public interface StudentDAO {

    // Öğrenci kaydetme işlemi için bir method tanımlanır.
    void save(Student student); // Öğrenci nesnesini veritabanına kaydedecek olan method.
}
