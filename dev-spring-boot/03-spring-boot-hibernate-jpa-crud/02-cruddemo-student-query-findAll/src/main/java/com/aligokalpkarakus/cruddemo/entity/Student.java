package com.aligokalpkarakus.cruddemo.entity;

import jakarta.persistence.*;

@Entity // Bu sınıfın bir JPA varlığı olduğunu belirtir.
@Table(name="student") // Bu varlığın "student" adlı tabloya eşlendiğini belirtir.
public class Student {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID'nin veri tabanında otomatik arttırılacağını belirtir.
    @Column(name="id") // Veritabanındaki "id" sütununa eşlenir.
    private int id;

    @Column(name="first_name") // Veritabanındaki "first_name" sütununa eşlenir.
    private String firstName;

    @Column(name="last_name") // Veritabanındaki "last_name" sütununa eşlenir.
    private String lastName;

    @Column(name="email") // Veritabanındaki "email" sütununa eşlenir.
    private String email;

    //define constructors
    public Student() {} // Parametresiz varsayılan yapıcı metod.

    public Student(String firstName, String lastName, String email) { // Parametreli varsayılan yapıcı metod.
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //define getters and setters
    public int getId() {return id;}
    public String getFirstName() {return firstName;}
    public String getLasttName() {return lastName;}
    public String getEmail() {return email;}
    public void setId(int id) {this.id = id;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setEmail(String email) {this.email = email;}

    //toString() method
    @Override
    public String toString() {
        // Öğrenci bilgilerini String formatında döndüren metod.
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
