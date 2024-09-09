package com.aligokalpkarakus.cruddemo.dao;

import com.aligokalpkarakus.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    //sadece okuma işlemi yapılacağı, bir güncelleme yapılmayacağı için transactional annotation'u yok.
    public List<Student> findAll() {
        // Tüm öğrencileri okumak için createQuery metodu kullanılır.
        //TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        // Burada "FROM Student" yazıyoruz çünkü "Student" entity name'dir, tablo ismi değil.
        // JPA syntax'ı entity name ve entity fields ile çalışır, bu nedenle tablo adı yerine entity adı kullanılır.

        //soyadın alfabetik sırasına göre çekmek için bir değişiklik. asc ascending yani artan, desc ise descending azalan.
        //asc veya desc kullanmadığımız sürece asc olarak davranır.
        TypedQuery<Student> query = entityManager.createQuery("FROM Student order by lastName asc", Student.class);

        // Query sonucunu alır ve bir liste olarak döndürür.
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //soyadı belirttiğimiz bir query oluşturalım.
        TypedQuery<Student> queryByLastName = entityManager.createQuery(
                                            "FROM Student WHERE lastName = :theData", Student.class);
                                            //:theData dediğimizdeki ":" JPQL named parameters are prefixed with this colon.
                                            //think of this as placeholder that is filled in later.

        //set query parameters
        queryByLastName.setParameter("theData", theLastName); //name parametresi theData, gerçek değer lastName

        //return query results
        return queryByLastName.getResultList();
    }

    @Override
    @Transactional // Bir update işlemi yapıldığı için @Transactional anotasyonunu ekliyoruz.
    public void update(Student student) {
        entityManager.merge(student);
        // merge metodu, verilen entity'yi günceller. Eğer entity daha önce veritabanında yoksa, yeni bir kayıt olarak ekler.
        // Eğer varsa, mevcut kaydı günceller.
    }

    @Override
    @Transactional //bir silme işlemi yaptığımız için ekliyoruz.
    public void delete(Integer id) {
        // Öğrenci ID'sine göre öğrenciyi buluyoruz
        Student student = findById(id);

        // Bulunan öğrenci kaydını veritabanından siliyoruz
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        //method name Update is a generic term. We are "modifying" the database
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
