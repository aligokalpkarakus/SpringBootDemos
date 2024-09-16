package com.aligokalpkarakus.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //Request mapping, o uzantılarda istekleri verileri tutar, yerleştirir, aktarır.

    // controller method to show initial HTML form
    // RequestMapping tüm HTML methodlarını (GET, POST...) destekler.
    // Bu methodları kısıtlamak istersek RequestMapping yerine ihtiyacımız olan mapping'i veririz
    // Sadece GET methodunu destekler. Buraya PostMapping verirsek browser hata verir
    // nedeni ise PostMapping gönderi isteklerini destekler. URL barda browser always submit GET requests.
    @GetMapping("/showForm")
    public String showForm(){

        //src/main/resources/templates/helloworld-form.html
        return "helloworld-form";
    }

    // controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        //src/main/resources/templates/helloworld-process.html
        return "helloworld-process";
    }

    // Controller method to read form data and add data to the model
    @RequestMapping("/processFormVerTwo")
    public String processFormVerTwo(HttpServletRequest request, Model model){
        // HttpServletRequest request: Bu parametre, gelen HTTP isteğiyle birlikte gönderilen form verilerini
        // okumak için kullanılır.

        // Read the request parameter from the HTML form
        // HTML formunda 'studentName' adlı input alanına girilen değeri request'ten alıyoruz.
        String theName = request.getParameter("studentName");

        // Convert the data to all caps
        // Alınan ismi büyük harfe çeviriyoruz.
        theName = theName.toUpperCase();

        // Create the message
        // Kullanıcının ismini içeren bir mesaj oluşturuyoruz.
        String result = "Yo! " + theName;

        // Add message to the model
        // Mesajı modele ekleyerek Thymeleaf tarafından kullanılmasını sağlıyoruz.
        model.addAttribute("message", result);

        // "helloworld-process" adındaki Thymeleaf sayfasına yönlendiriyoruz.
        return "helloworld-process";
    }

    /*
    Controller method to read form data and add data to the model
    formda GET metodu belirtildiği için GetMapping doğru çalışır.
    formda POST metodu belirtelim ve gözlemleyelim. Hata verdi.
    çünkü burada GetMapping ile anotasyon verirken formda POST metodunu verdik. Bu hataya sebep olur.
    Burayı GetMapping'den PostMapping'e çevirelim. Formda POST kalsın.
    Bu sefer çalıştı. Çünkü formdaki metod ile buradaki anotasyon uyuyor.
    */
    /*
    Post ve Get'in belirli farklılıkları var:

    1- Get yaptığımızda data URL'de gözükürken Post'ta gözükmez, HTTP Request Message body içinde gönderilir.
    Debug için Get ile yapmak daha faydalı.
    2- Get'te URL karakter sınırlaması varken Post'ta yoktur. Yani 1000 karakteri aşıyorsa Post daha uygun.
    3- Post'ta binary data gönderebiliriz. Dosya ekleme yükleme gibi durumlarda kullanılabilir.
    */
    @PostMapping("/processFormVerThree")
    public String processFormVerThree(
            @RequestParam("studentName") String theName, Model model) {

    /* RequestParam handles this process behind the scenes.
       @RequestParam kullanılarak, HTML formundan gelen 'studentName' parametresini doğrudan alıyoruz.
       Yani request.getParameter() yöntemini kullanmamıza gerek kalmadan, Spring otomatik olarak bu işlemi yapıyor.
       */

        // Convert the data to all caps
        // Girilen ismi büyük harfe çeviriyoruz, böylece kullanıcıya büyük harfli bir şekilde gösterilecek.
        theName = theName.toUpperCase();

        // Create the message
        // Mesajı oluşturuyoruz, burada kullanıcıya hitap eden bir mesaj hazırlanıyor.
        String result = "Hey my friend from v3! " + theName;

        // Add message to the model
        // Model objesi ile mesajı ekliyoruz. Bu mesaj, Thymeleaf sayfasında görüntülenecek olan dinamik veriyi temsil eder.
        model.addAttribute("message", result);

        // Returning the view name "helloworld-process"
        // "helloworld-process" isimli Thymeleaf sayfasına yönlendirme yapılıyor. Bu sayfa, modeldeki veriyi kullanarak gösterim yapacak.
        return "helloworld-process";
    }



}
