package com.aligokalpkarakus.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// ControllerAdvice, uygulama genelinde birden fazla denetleyici için hata işleme stratejilerini merkezi olarak tanımlamak için kullanılır.
// Hatalar, bu sınıfta tanımlanan yöntemlerle işlenir ve uygun yanıtlar döndürülür.
@ControllerAdvice
public class StudentRestGlobalExceptionHandler {

    // add exception handling code here.

    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    //             <Response type for the response body>      (Exception type to handle/catch)
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value()); // HTTP durum kodu olarak 404 Not Found atanır.
        error.setMessage(exc.getMessage()); // İstisnanın mesajı atanır.
        error.setTimeStamp(System.currentTimeMillis()); // Hata zaman damgası atanır.

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // Hata yanıtını HTTP 404 Not Found ile döner.
    }

    // Add another exception handler to catch any exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value()); // HTTP durum kodu olarak 400 Bad Request atanır.
        error.setMessage(exc.getMessage()); // İstisnanın mesajı atanır.
        error.setTimeStamp(System.currentTimeMillis()); // Hata zaman damgası atanır.

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); // Hata yanıtını HTTP 400 Bad Request ile döner.
    }
}
