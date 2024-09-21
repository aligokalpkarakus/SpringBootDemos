package com.aligokalpkarakus.springboot.securitydemo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration // Bu sınıfın Spring için bir yapılandırma sınıfı olduğunu belirtir.
public class SecurityConfiguration {

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
}
