package com.aligokalpkarakus.springboot.cruddemo.dao;

import com.aligokalpkarakus.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// EmployeeRepository arayüzü, JpaRepository arayüzünü genişletiyor.
// Bu sayede, CRUD işlemleri (Create, Read, Update, Delete) için gerekli olan
// tüm temel metotları yazmamıza gerek kalmıyor.

//@RepositoryRestResource(path="members") //bu anotasyon localhost:8080/magic-api/employees yerine
//localhost:8080/magic-api/members olarak erişmemizi sağlar.
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Burada ek bir kod yazmaya gerek yok!
    // JpaRepository bize findAll(), findById(), save() gibi
    // kullanışlı metodlar sağlar.
    // Eski DAO sınıflarına gerek yok çünkü JpaRepository ile
    // tüm CRUD operasyonları hazır olarak gelir.
}
