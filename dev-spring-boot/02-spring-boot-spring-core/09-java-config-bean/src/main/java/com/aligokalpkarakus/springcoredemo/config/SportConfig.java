package com.aligokalpkarakus.springcoredemo.config;

import com.aligokalpkarakus.springcoredemo.common.Coach;
import com.aligokalpkarakus.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Bu sınıf, Spring'in uygulama bağlamında kullanılacak olan bean tanımlarını içeren bir yapılandırma sınıfıdır.
@Configuration
public class SportConfig {

    // Bu metod bir bean tanımlar ve Spring konteynerine geri döndürür.
    // @Bean anotasyonu, bu metodun dönüş değerini bir Spring bean'i olarak kaydeder.
    // Bean id'si varsayılan olarak metod adı olacaktır. Yani, bu durumda "swimCoach" olacaktır.
    // Buradaki amaç şu: 3. parti bir yazılımı spring boot'ta kullanacağımız zaman, @Component'i ile kullanamıyoruz.
    // Çünkü o yazılım Spring Boot bean'i değil.
    // Onu kullanabilmek için bu şekilde o yazılımı Bean olarak kullanmayı sağlıyoruz.
    // Yani temel amaç bir 3. parti sınıfı alarak onu Spring Bean'e dönüştürmek. Bu o yazılımı kullanabilmemizi sağlar.
    //@Bean
    @Bean("yüzücü") //bu şekilde de manuel olarak id verebiliriz. Metod yerine böyle çağırmamızı sağlar.
    public Coach swimCoach() {
        // Bu metod, SwimCoach türünde bir bean oluşturur ve döndürür.
        return new SwimCoach();
    }
}
