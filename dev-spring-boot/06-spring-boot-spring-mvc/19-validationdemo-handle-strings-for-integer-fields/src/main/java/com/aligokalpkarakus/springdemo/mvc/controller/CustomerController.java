package com.aligokalpkarakus.springdemo.mvc.controller;

import com.aligokalpkarakus.springdemo.mvc.Model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    // add an initbinder... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation
    // şöyle bir problemimiz var: kullancı soyadına sadece boşluklardan oluşan input verdiğinde bunu soyad olarak alıyor
    // ya da soyad yazsa da başına ve sonuna koyduğu boşlukları da alıyor.
    // bunu önlemek için kullanacağımız method:
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // bu method:
        // pre-process every String form data
        // remove leading and trailing white space
        // if String only has white space, trim it to null.
        // bu method, gelen her web isteği için çağırılacak ve bu yazdığımız metoddaki StringTrimmerEditor'e verdiğimiz
        // true ile boşluklarla ilgili işlemler hep aktif olacak.

        //tamamen boşluktan oluşuyorsa tüm boşlukları silerek null haline çevirecek true dememiz.
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model model) {

        model.addAttribute("customer", new Customer());

        return "customer-form";

    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult) {
        //@Valid tell spring MVC to perform validation.
        //@ModelAttribute ile geçen customer objesi, @Valid ile belirlenen validation kurallarına
        //(@NotNull, @Size) göre doğrulama yapar.
        //BindingResult, @Valid anotasyonunun doğrulaması hakkındaki sonucu taşır. Yani @Valid'den
        //ne döndüyse bunu bindingResult'ta bulacağız.

        // Custom error names için debugging'i şu şekilde yapabiliriz.
        // BindingResult bizim için çok zengin bir veri. Buradan neyin ne olduğunu görebiliriz
        System.out.println("Binding results: " + bindingResult.toString());
        System.out.println("\n\n\n\n");


        if (bindingResult.hasErrors()) {
            //bindingResult'taki cevapta hata var bilgisi varsa customer-form'a geri dönülecek.
            return "customer-form";
        }else{
            //hata yoksa customer-confirmation'a geçilecek.
            return "customer-confirmation";
        }

    }

}
