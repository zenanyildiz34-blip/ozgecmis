# PDF Özgeçmiş (CV) Oluşturucu

Bu proje, Java programlama dili ve OpenPDF kütüphanesi kullanılarak nesne yönelimli programlama (OOP) prensiplerine uygun şekilde geliştirilmiş bir PDF özgeçmiş (CV) üretim uygulamasıdır.
Kullanıcıya ait kişisel bilgileri, profil fotoğrafını, yetkinlikleri ve iş deneyimlerini düzenli bir mizanpaj ile A4 formatında PDF belgesine dönüştürür.

---

## Proje Özellikleri

- **Ayrık Mimari:** PDF üretim mantığı doğrudan `main` metodu içinde yürütülmez; sorumlulukların ayrılığı (Single Responsibility Principle) gereğince özel servis katmanında ele alınır.
- **Kapsülleme (Encapsulation):** Veri modellerindeki tüm alanlar `private` erişim belirteci ile korunur, verilere erişim kontrollü `public` metotlar (getter/setter) üzerinden sağlanır.
- **Dinamik İçerik Yönetimi:** Kişisel bilgiler, eğitim geçmişi, beceriler, sertifikalar ve 3 adet hayali iş deneyimi nesne yönelimli olarak modellenir.
- **Fotoğraf ve Görsel Düzen:** Profil fotoğrafı dinamik olarak boyutlandırılarak PDF üst başlık mizanpajına entegre edilir.
- **Unicode Desteği:** Türkçe karakterlerin (`ç, ğ, ı, ö, ş, ü, İ, Ğ, Ş`) ve özel karakterlerin sorunsuz işlenmesi sağlanmıştır.

---

## Kullanılan Teknolojiler ve Bileşenler

| Teknoloji / Kütüphane | Sürüm | Kullanım Amacı |
| :--- | :--- | :--- |
| **Java (JDK)** | 25 | Temel programlama dili ve çalışma zamanı ortamı |
| **Maven** | 3.x | Bağımlılık yönetimi ve proje derleme aracı |
| **OpenPDF** | 1.3.39 | PDF dökümanı oluşturma, biçimlendirme ve sayfa mizanpajı kütüphanesi |

---

## Mimari Yapı ve Nesne Tasarımı

Proje `org.example` kök paketi altında model ve servis katmanlarına ayrılmıştır:

```text
src/main/java/org/example/
├── model/
│   ├── Experience.java       # İş deneyimlerini temsil eden veri modeli
│   └── Person.java           # Kişisel ve profesyonel bilgileri barındıran veri modeli
├── service/
│   └── PdfService.java       # PDF oluşturma işlemlerinden sorumlu servis sınıfı
└── Main.java                 # Veri nesnelerini başlatan ve süreci tetikleyen ana sınıf
