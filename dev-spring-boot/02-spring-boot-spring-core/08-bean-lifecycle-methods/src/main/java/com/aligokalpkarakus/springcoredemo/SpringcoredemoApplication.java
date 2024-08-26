package com.aligokalpkarakus.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Bu anotasyon, Spring Boot uygulaması olarak sınıfı işaretler ve birden fazla yapılandırma sağlar.
// "scanBasePackages" parametresi ile belirtilen paketler Spring tarafından taranacaktır.
// Bu olayı SpringcoredemoApplication class'ımın olmadığı yerde bir paket varsa onu taramak için kullanıyoruz.
// Tarama bileşeninden faydalanmak için yaptıklarımızı geri alıyoruz: util klasöründeki Coach ve CricketCoach'ı
// tekrar common'a koyduk.
/*
@SpringBootApplication(
		scanBasePackages = {"com.aligokalpkarakus.util",
							"com.aligokalpkarakus.springcoredemo"})

 */
// Bu anotasyon, Spring Boot uygulaması olarak sınıfı işaretler ve birden fazla yapılandırma sağlar.
@SpringBootApplication
public class SpringcoredemoApplication {

	// Ana metod (main method) Spring Boot uygulamasını başlatır.
	public static void main(String[] args) {
		// Spring Boot uygulamasını çalıştırır.
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}
}
