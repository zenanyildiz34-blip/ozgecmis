package org.example;

import org.example.model.Experience;
import org.example.model.Person;
import org.example.service.PdfService;

public class Main {
    public static void main(String[] args) {
        Person person = new Person(
                "ZENAN YILDIZ",
                "YAZILIM MÜHENDİSLİĞİ ÖĞRENCİSİ",
                "Yazılım mühendisliği 4. sınıf öğrencisiyim. Yazılım geliştirme alanında kendimi geliştirmeye odaklanıyorum. Öğrenmeye açık, disiplinli ve ekip çalışmasına yatkın biriyim.",
                "Detaylara önem veren, işini severek yapan ve sürekli gelişime açık biriyim. Yeni bilgiler öğrenmeyi ve kendimi zihinsel olarak geliştirmeyi öncelik edinirim. Disiplinli, özenli ve istekli çalışmanın başarıyı getireceğine inanıyor, bu doğrultuda kariyerimi şekillendirmek istiyorum.",
                "+90 000 000 00 00",
                "1250505005@gmail.com",
                "linkedin.com/in/zenan-yıldız-233238385",
                "İstanbul",
                "2023 - 2027 : Kırklareli Üniversitesi - Yazılım Mühendisliği\n2018 - 2022 : İstanbul Anadolu Lisesi",
                "profile.jpg"
        );

        // Beceriler
        person.addSkill("C");
        person.addSkill("Python");
        person.addSkill("Microsoft Office");

        // Yabancı Diller
        person.addLanguage("İngilizce (A2-B1)");

        // Kurslar ve Sertifikalar
        person.addCertificate("BTK Akademi - Algoritma ve Veri Yapıları İleri Seviye");
        person.addCertificate("BTK Akademi - Veri Modelleme");
        person.addCertificate("BTK Akademi - C Programlama Dili");
        person.addCertificate("BTK Akademi - Yazılım Geliştirme Araçları");
        person.addCertificate("BTK Akademi - Bilgi Teknolojilerine Giriş");

        // 3 Hayali İş Deneyimi
        person.addExperience(new Experience(
                "AeroTech Otonom Sistemler A.Ş.",
                "Gömülü Yazılım ve Kontrol Stajyeri",
                "Haziran 2025 - Eylül 2025",
                "İnsansız hava araçları kontrol kartları üzerinde C dili ile sensör haberleşme protokolleri (I2C, SPI) ve telemetri veri iletim modüllerinin test senaryolarında görev alındı."
        ));

        person.addExperience(new Experience(
                "Pusula Dijital Çözümler Ltd.",
                "Junior Backend Geliştirici",
                "Ekim 2024 - Mayıs 2025",
                "Java ve nesne yönelimli programlama prensipleri doğrultusunda RESTful servislerin geliştirilmesi, veri modelleme ve temel veri yapıları optimizasyon süreçleri yürütüldü."
        ));

        person.addExperience(new Experience(
                "Nova Ar-Ge & Yazılım Laboratuvarı",
                "Aday Mühendis / Araştırma Asistanı",
                "Ocak 2024 - Ağustos 2024",
                "Görüntü işleme algoritmalarının simülasyon ortamındaki performans testleri gerçekleştirildi; gerçek zamanlı veri akışı ve nesne tanıma modelleri için veri ön işleme süreçlerine katkı sağlandı."
        ));

        // PDF Üretimini Başlat
        PdfService pdfService = new PdfService();
        pdfService.createResume(person, "ozgecmis.pdf");
    }
}