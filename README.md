# Program Java: Demonstrasi Exception Handling

## Tujuan Program

Proyek ini berisi dua program Java (`checkedException.java` dan `uncheckedException.java`) yang bertujuan untuk mendemonstrasikan penerapan mekanisme *exception handling* menggunakan *`try-catch` statement* dan *`throws` clause*. Program ini menunjukkan bagaimana cara menangani error yang mungkin terjadi saat runtime agar aplikasi tidak berhenti secara tiba-tiba dan dapat memberikan respons yang sesuai.

## Implementasi dan Tipe Exception

### 1. `checkedException.java`

Program ini mendemonstrasikan penanganan **checked exception**, yaitu `java.lang.InterruptedException`.

* **Tujuan Kode:**
    * Mensimulasikan proses loading yang dapat diinterupsi.
    * Menunjukkan dua pendekatan untuk menangani `InterruptedException` yang dilempar oleh `Thread.sleep()`:
        1.  **`LoadingTipe1`**: Menggunakan klausa `throws InterruptedException` pada *method signature* untuk mendelegasikan penanganan *exception* ke kode pemanggil. Pemanggil metode ini wajib menangani *exception* tersebut menggunakan `try-catch`.
        2.  **`LoadingTipe2`**: Menangani `InterruptedException` secara internal di dalam metode menggunakan blok `try-catch-finally`. Blok `finally` memastikan pesan "Loading selesai" selalu dieksekusi.

* **Tipe Exception yang Digunakan:**
    * `java.lang.InterruptedException`: Sebuah *checked exception* yang terjadi ketika sebuah thread yang sedang menunggu, tidur, atau melakukan operasi yang dapat diinterupsi (seperti `Thread.sleep()`) diinterupsi oleh thread lain.

`Thread.sleep(ms)` adalah metode di Java yang digunakan untuk menghentikan sementara eksekusi thread selama waktu tertentu (dalam milidetik). Karena proses ini bisa terinterupsi oleh thread lain, maka `Thread.sleep()` melempar InterruptedException, yang merupakan checked exception. Artinya, saat menggunakan `Thread.sleep()`, program wajib menangani exception tersebut, baik dengan `try-catch` atau menambahkan `throws InterruptedException` pada deklarasi metode.

### 2. `uncheckedException.java`

Program ini mendemonstrasikan penanganan **unchecked exception**, khususnya `java.lang.NumberFormatException`.

* **Tujuan Kode:**
    * Menerima input string dari pengguna dan mencoba mengonversinya menjadi integer.
    * Menangani potensi `NumberFormatException` jika input yang diberikan tidak dapat dikonversi menjadi angka.
    * Menggunakan blok `try-catch-finally` untuk menangkap *exception*, memberikan pesan error yang informatif kepada pengguna, dan memastikan blok `finally` selalu dieksekusi.

* **Tipe Exception yang Digunakan:**
    * `java.lang.NumberFormatException`: Sebuah *unchecked exception* yang terjadi ketika ada upaya untuk mengonversi string ke tipe numerik, tetapi format string tersebut tidak valid atau tidak merepresentasikan angka yang valid.
    * `java.lang.Exception` (general): Digunakan sebagai *catch block* tambahan untuk menangkap *exception* lain yang mungkin tidak tertangani secara spesifik.

Kedua program ini mengilustrasikan pentingnya *exception handling* dalam membuat program yang robust dan *user-friendly*.
