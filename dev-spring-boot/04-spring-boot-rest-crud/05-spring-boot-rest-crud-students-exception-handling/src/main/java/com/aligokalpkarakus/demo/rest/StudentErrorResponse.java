package com.aligokalpkarakus.demo.rest;

// Bu sınıf, REST API'de meydana gelen hataların istemciye daha anlamlı bir şekilde iletilmesi için kullanılır.
public class StudentErrorResponse {

    // Hatanın HTTP durum kodunu içerir (örneğin 404, 500 gibi).
    private int status;

    // Hata hakkında daha fazla bilgi veren bir açıklama içerir.
    private String message;

    // Hatanın meydana geldiği zamanı belirten bir zaman damgası içerir.
    private long timeStamp;

    // Boş yapıcı: Gerekirse boş bir StudentErrorResponse nesnesi oluşturulmasına olanak tanır.
    public StudentErrorResponse() {}

    // Parametreli yapıcı: Hatanın durumu, mesajı ve zaman damgası ile bir StudentErrorResponse nesnesi oluşturur.
    public StudentErrorResponse(int status, String message, long timeStamp) {
        this.status = status; // HTTP durum kodu ayarlanır.
        this.message = message; // Hata mesajı ayarlanır.
        this.timeStamp = timeStamp; // Zaman damgası ayarlanır.
    }

    // Hatanın HTTP durum kodunu döndürür.
    public int getStatus() {
        return status;
    }

    // Hatanın HTTP durum kodunu ayarlar.
    public void setStatus(int status) {
        this.status = status;
    }

    // Hata mesajını döndürür.
    public String getMessage() {
        return message;
    }

    // Hata mesajını ayarlar.
    public void setMessage(String message) {
        this.message = message;
    }

    // Hatanın meydana geldiği zaman damgasını döndürür.
    public long getTimeStamp() {
        return timeStamp;
    }

    // Hatanın meydana geldiği zaman damgasını ayarlar.
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
