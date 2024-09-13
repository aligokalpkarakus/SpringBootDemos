package com.aligokalpkarakus.springboot.cruddemo.dao;

import com.aligokalpkarakus.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// EmployeeRepository arayüzü, JpaRepository arayüzünü genişletiyor.
// Bu sayede, CRUD işlemleri (Create, Read, Update, Delete) için gerekli olan
// tüm temel metotları yazmamıza gerek kalmıyor.

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Burada ek bir kod yazmaya gerek yok!
    // JpaRepository bize findAll(), findById(), save() gibi
    // kullanışlı metodlar sağlar.
    // Eski DAO sınıflarına gerek yok çünkü JpaRepository ile
    // tüm CRUD operasyonları hazır olarak gelir.
}
