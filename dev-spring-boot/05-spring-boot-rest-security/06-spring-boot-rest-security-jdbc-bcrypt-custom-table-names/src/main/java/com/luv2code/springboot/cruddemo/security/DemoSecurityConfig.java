package com.luv2code.springboot.cruddemo.security;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.TypedQuery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration // Bu sınıfın bir konfigürasyon sınıfı olduğunu belirtir.
public class DemoSecurityConfig {
    //Application properties'de tanımladığımız username ve password, bu classtan dolayı Spring Boot o bilgileri
    //kullanmayacak.

    /* Çalışanları veritabanına taşıdığımız için yoruma aldık.
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
     */

    // Add support for JDBC... no more hardcoded users.
    @Bean                                       //Inject data source Auto-configured by Spring Boot
    public UserDetailsManager userDetailsManager (DataSource dataSource) {

        // Custom table db için comment'a aldık son satırı.
        // it tells spring security to use JDBC authentication with our data source
        // spring security bununla önceden tanımlanmış bir tablo şeması kullandığını bilir
        // dolayısıyla spring security, Users adlı bir tabloya bakar.
        //return new JdbcUserDetailsManager(dataSource);

        //This is all custom. Nothing matches with default Spring Security table schema.
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT user_id, pw, active FROM members WHERE user_id=?"
                //"?" parameter value will be the username from login
        );

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT user_id, role FROM roles WHERE user_id=?"
                //"?" parameter value will be the username from login
        );

        return jdbcUserDetailsManager;


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

