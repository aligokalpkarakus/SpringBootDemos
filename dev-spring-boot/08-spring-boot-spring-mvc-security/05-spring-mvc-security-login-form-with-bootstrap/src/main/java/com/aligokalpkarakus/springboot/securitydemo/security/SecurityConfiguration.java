package com.aligokalpkarakus.springboot.securitydemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Bu sınıfın Spring için bir yapılandırma sınıfı olduğunu belirtir.
public class SecurityConfiguration {

    @Bean
    // Kullanıcı detaylarını yönetecek bir `InMemoryUserDetailsManager` döndüren metot.
    public InMemoryUserDetailsManager userDetailsManager() {

        // "john" isimli bir kullanıcı oluşturuyoruz.
        UserDetails john = User.builder()
                .username("john") // Kullanıcı adı
                .password("{noop}test123") // Şifre, {noop} ile şifreleme olmadan düz metin şifre kullanılıyor.
                .roles("EMPLOYEE") // "EMPLOYEE" rolü atandı.
                .build(); // Kullanıcıyı oluştur

        // "mary" isimli bir kullanıcı oluşturuyoruz.
        UserDetails mary = User.builder()
                .username("mary") // Kullanıcı adı
                .password("{noop}test123") // Şifre
                .roles("EMPLOYEE", "MANAGER") // "EMPLOYEE" ve "MANAGER" rolleri atandı.
                .build();

        // "susan" isimli bir kullanıcı oluşturuyoruz.
        UserDetails susan = User.builder()
                .username("susan") // Kullanıcı adı
                .password("{noop}test123") // Şifre
                .roles("EMPLOYEE", "MANAGER", "ADMIN") // "EMPLOYEE", "MANAGER" ve "ADMIN" rolleri atandı.
                .build();

        // Üç kullanıcıyı bellekte saklayacak bir `InMemoryUserDetailsManager` nesnesi döndürüyoruz.
        return new InMemoryUserDetailsManager(john, mary, susan);
    }

    @Bean // Bu metot, bir Spring Bean'i olarak tanımlanır.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Yetkilendirme kurallarını ayarlıyoruz.
        http.authorizeHttpRequests(configurer ->
                        configurer
                                // Herhangi bir istek için kimlik doğrulama yapılmasını zorunlu kılıyor.
                                .anyRequest().authenticated()
                )
                // Form tabanlı kimlik doğrulama ayarları
                .formLogin(form ->
                        form
                                // Giriş sayfasının özel URL'sini belirliyor.
                                .loginPage("/showMyLoginPage")
                                // Formdaki verilerin işleneceği URL.
                                // Bunun için controller'da bir request mapping'e gerek yok.
                                // Spring sec kendisi sağlıyor.
                                .loginProcessingUrl("/authenticateTheUser")
                                // Giriş sayfasına herkesin erişebilmesini sağlar.
                                .permitAll()
                );

        // HTTP güvenlik yapılandırmasını tamamlayıp döndürüyoruz.
        return http.build();
    }


}
