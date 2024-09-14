package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration // Bu sınıfın bir konfigürasyon sınıfı olduğunu belirtir.
public class DemoSecurityConfig {
    //Application properties'de tanımladığımız username ve password, bu classtan dolayı Spring Boot o bilgileri
    //kullanmayacak.

    // Kullanıcı bilgilerini bellekte tutacak olan yönetici objesini oluşturuyoruz.
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        // 'john' adında bir kullanıcı oluşturuyoruz, şifresi 'john' ve sadece 'EMPLOYEE' rolü var.
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123") // {noop} parola şifrelenmemiş olduğunu gösterir.
                .roles("EMPLOYEE")
                .build();

        // 'mary' adında bir kullanıcı oluşturuyoruz, şifresi 'mary' ve 'EMPLOYEE' ile 'MANAGER' rolleri var.
        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        // 'susan' adında bir kullanıcı oluşturuyoruz, şifresi 'susan', 'EMPLOYEE', 'MANAGER' ve 'ADMIN' rolleri var.
        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        // InMemoryUserDetailsManager ile yukarıda tanımladığımız kullanıcıları bellekte saklıyoruz.
        return new InMemoryUserDetailsManager(john, mary, susan);
    }
}

