package com.aligokalpkarakus.cruddemo.dao;

import com.aligokalpkarakus.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// Bu sınıfı bir repository (veri erişim katmanı) olarak işaretler, JDBC istisnalarını Spring'in çevirmesini sağlar.
@Repository //Specialized annotation for repositories, supports component scanning, translates jdbc exceptions.
public class StudentDAOImpl implements StudentDAO {

    //define field for entity manager
    private EntityManager entityManager; // JPA üzerinden veritabanı işlemlerini yöneten bileşen.

    //inject entity manager using constructor injecition
    @Autowired // Spring'in EntityManager'ı otomatik olarak enjekte etmesini sağlar (constructor injection).
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager; // Gelen entityManager nesnesi sınıfın alanına atanır.
    }

    //implement save method
    @Override
    @Transactional // Metodun bir veritabanı işlemi (transaction) olarak çalışmasını sağlar.
    public void save(Student student) {
        entityManager.persist(student); // Veritabanına yeni bir öğrenci kaydı ekler.
    }

    @Override
    //sadece okuma işlemi yapılacağı, bir güncelleme yapılmayacağı için transactional annotation'u yok.
    public Student findById(int id) {
        return entityManager.find(Student.class, id); //Student bir entity, id ise primary key.
    }
}
