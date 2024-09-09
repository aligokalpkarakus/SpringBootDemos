package com.aligokalpkarakus.cruddemo;

import com.aligokalpkarakus.cruddemo.dao.StudentDAO;
import com.aligokalpkarakus.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			//createStudent(studentDAO); //veritabanında student'i kaydediyoruz

			//ID'nin otomatik artışını gözlemlemek için birden fazla student kaydediyoruz.
			//createMultipleStudents(studentDAO);

			//Yarattığımız student'i veritabanındaki id'si ile bulup bilgilerini yazdırıyoruz.
			//readStudent(studentDAO);

			//Tüm öğrencileri veritabanından okumak için method.
			//queryForStudents(studentDAO);

			//Soyada göre öğrencileri veritabanından okumak için method.
			queryForStudentsByLastName(studentDAO);
		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> students = studentDAO.findByLastName("Özkal");

		//display list of students
		students.forEach(System.out::println);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> students = studentDAO.findAll();

		//display list of students
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating student...");
		Student student = new Student("Gökalp","Karakus","gokalp@gmail.com");

		//save the student
		System.out.println("Saving student...");
		studentDAO.save(student);

		//display id of the saved student
		int theId = student.getId();
		System.out.println("Saved student's id: " + theId);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student dbStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: " + dbStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 students...");
		Student student1 = new Student("Selin", "Özkal", "selin@gmail.com");
		Student student2 = new Student("Zeynep", "Özkal", "zeynep@gmail.com");
		Student student3 = new Student("Melinda", "Opeth", "melinda@gmail.com");

		//save the student objects
		System.out.println("Students created and saved...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating student...");
		Student student = new Student("Ali Gokalp", "Karakus", "aligokalpkarakus@gmail.com");

		//save the student object
		System.out.println("Student created and saved...");
		studentDAO.save(student);

		//display id of the saved student
		System.out.println("Student saved. Generated id: " + student.getId());
	}

}
