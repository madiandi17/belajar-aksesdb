# belajar-aksesdb
Belajar akses database dengan DAO dan service pattern.

Akses terhadap database merupakan bagian yang penting dari aplikasi database.Penggunaan pattern yang sesuai dapat memberikan manfaat sangat besar. Pattern yang sering digunakan dalam database adalah DAO (Data Access Object) dan Service/Facade pattern.

Kedua pattern ini digunakan untuk menerapkan “separation of concern” atau pemisahan kode program berdasarkan fungsi kode program. Semua kode untuk akses data harus dipisahkan dengan kode untuk pengaturan user inteface. Hal ini memungkinkan kode akses data yang dibuat untuk aplikasi desktop, dengan mudah digunakan untuk aplikasi web.

Dao pattern berisi semua kode untuk mengakses data, seperti query. Semua kode yang sepesifk terhadap implementasi akses data berhenti di sini, lapisan lebih atas tidak boleh tahu bagaimana akses data diterapkan, apakah menggunakan JDBC murni atau Hibernate atau JPA. Lapisan lainya
hanya perlu tahu fungsionalitas dari suatu method di dalam DAO class, tidak perlu tahu bagimana method tersebut diimplementasikan. Class DAO akan mempunyai method seperti save, delete, getById atau getAll. Praktek yang lazim digunakan adalah satu buah Entity/Table akan mempunyai satu buah class DAO. Bagian ini mempraktekan bagaimana melakukan akses database menggunakan pattern DAO dan Service pattern.
