package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // İstekleri yetkilendirme kurallarını tanımlar
        http.authorizeHttpRequests(configurer ->
                configurer
                        // "/api/employees" ve "/api/employees/**" GET istekleri sadece "EMPLOYEE" rolüne sahip kullanıcılar tarafından erişilebilir
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        // "/api/employees" POST ve PUT istekleri sadece "MANAGER" rolüne sahip kullanıcılar tarafından erişilebilir
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
                        // "/api/employees/**" DELETE istekleri sadece "ADMIN" rolüne sahip kullanıcılar tarafından erişilebilir
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // use HTTP Basic authentication
        // HTTP Basic Authentication kullanarak kimlik doğrulaması yap
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        // HTML formları içeren web uygulamaları içindir CSRF.
        // Cross-Site Request Forgery (CSRF) korumasını devre dışı bırak
        // CSRF koruması genellikle REST API'ler için gerekmez, çünkü API'ler stateless'dır (durumsuz)
        http.csrf(csrf -> csrf.disable());

        return http.build();

    }












}

