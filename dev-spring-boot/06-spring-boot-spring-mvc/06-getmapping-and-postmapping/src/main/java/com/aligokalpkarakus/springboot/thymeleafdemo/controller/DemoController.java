package com.aligokalpkarakus.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Bu sınıfı bir Spring MVC kontrolcüsü olarak tanımlar. Gelen istekleri karşılar ve yanıt olarak bir HTML sayfası döndürür.
@Controller
public class DemoController {

    // create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello(Model model) {

        // Model'e "theDate" isimli bir attribute ekliyoruz. Bu attribute, Thymeleaf şablonunda kullanılmak üzere
        // java.time.LocalDateTime.now() ile mevcut tarihi ve zamanı içerir.
        model.addAttribute("theDate", java.time.LocalDateTime.now());

        // Thymeleaf bağımlılığı pom.xml'de tanımlandığı için Spring Boot otomatik olarak Thymeleaf'i yapılandırır.
        // Bu metod "helloworld" adlı şablonu döndürdüğünde, Spring "src/main/resources/templates/" dizininde
        // "helloworld.html" dosyasını arar ve bulursa, şablon ile beraber döndürür.
        return "helloworld";

        //we have thymeleaf dependency in maven pom, so spring boot will auto-configure to use thymeleaf.
        //when we return "helloworld" it is going to in: src/main/resources/templates/helloworld.html

        // "helloworld" döndürdüğümüzde, Thymeleaf şablon motoru "helloworld.html" dosyasını arar.
        // "theDate" modeli bu şablonda kullanılabilir, örneğin tarihin kullanıcıya gösterilmesi için.
    }
}
