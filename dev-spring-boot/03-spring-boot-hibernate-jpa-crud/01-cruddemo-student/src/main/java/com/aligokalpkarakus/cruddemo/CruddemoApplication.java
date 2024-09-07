package com.aligokalpkarakus.cruddemo;

import com.aligokalpkarakus.cruddemo.dao.StudentDAO;
import com.aligokalpkarakus.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

// Bu anotasyon, uygulamanın bir Spring Boot uygulaması olduğunu belirtir.
@SpringBootApplication
public class CruddemoApplication {

	// main metodu, uygulamanın giriş noktasıdır. Spring Boot uygulamasını başlatır.
	public static void main(String[] args) {
		// Spring Boot uygulamasını başlatmak için SpringApplication.run() metodu kullanılır.
		SpringApplication.run(CruddemoApplication.class, args);
	}

	/*
	// CommandLineRunner bean'i tanımlanıyor.
	// Bu bean, uygulama başladığında komut satırında çalışacak olan kodu içerir.
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		// CommandLineRunner arayüzünü lambda ifadesiyle uygular.
		// Uygulama başlatıldığında "Hello World" mesajı komut satırına yazdırılır.
		return runner -> {
			System.out.println("Hello World");
		};
	}
	*/

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		// CommandLineRunner arayüzünü lambda ifadesiyle uygular.
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating student...");
		Student student = new Student("Ali Gokalp", "Karakus", "aligokalpkarakus@gmail.com");

		//save the student object
		System.out.println("Student created...");
		studentDAO.save(student);

		//display id of the saved student
		System.out.println("Student saved. Generated id: " + student.getId());
	}

}
