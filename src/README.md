# Aplikasi Pembayaran NIM

Aplikasi Pembayaran NIM adalah aplikasi berbasis desktop yang memungkinkan pengguna untuk memasukkan data mahasiswa, melakukan pembayaran berdasarkan NIM, dan melihat riwayat pembayaran. Aplikasi ini dirancang dengan menggunakan Java dan Swing untuk antarmuka pengguna grafis (GUI).

## Fitur Aplikasi

1. Data Mahasiswa  
   Menyimpan informasi tentang mahasiswa, termasuk NIM, nama, jurusan, fakultas, angkatan, dan saldo. Data mahasiswa ini dapat ditambah melalui antarmuka pengguna.

2. Pembayaran NIM  
   Pengguna dapat memasukkan NIM, jurusan, dan jumlah pembayaran. Setelah data diverifikasi, aplikasi akan memproses pembayaran dan mengurangi saldo mahasiswa sesuai dengan jumlah pembayaran yang dilakukan.

3. Riwayat Pembayaran  
   Aplikasi menyimpan riwayat pembayaran yang mencatat siapa yang telah melakukan pembayaran, berapa jumlah yang dibayarkan, serta jurusan dan angkatan mahasiswa tersebut.

## Prasyarat

Sebelum menjalankan aplikasi ini, pastikan Anda memiliki hal-hal berikut:

- Java 8 atau versi lebih tinggi terinstal di sistem Anda.
- IDE seperti IntelliJ IDEA, Eclipse, atau NetBeans untuk mengelola dan menjalankan kode Java.

## Instalasi

1. Clone atau download repository ini ke komputer Anda.
2. Masuk ke direktori proyek yang telah di-download.
3. Buka proyek di IDE pilihan Anda.
4. Pastikan semua file Java berada dalam satu folder, dan tidak ada dependensi eksternal selain Java Swing.
5. Jalankan program melalui IDE atau menggunakan terminal dengan perintah berikut:


## Cara Penggunaan

### Menambah Data Mahasiswa

1. Masukkan data mahasiswa seperti NIM, nama, jurusan, fakultas, angkatan, dan saldo pada form yang tersedia.
2. Klik "Tambah Mahasiswa" untuk menambahkan data ke dalam sistem.
3. Data yang berhasil ditambahkan akan muncul dalam tabel di antarmuka.

### Melakukan Pembayaran

1. Masukkan NIM mahasiswa yang ingin melakukan pembayaran.
2. Pilih jurusan mahasiswa yang sesuai (ini akan divalidasi bersama NIM).
3. Masukkan jumlah pembayaran dan klik *Bayar*.
4. Saldo mahasiswa akan berkurang sesuai dengan jumlah yang dibayarkan.
5. Riwayat pembayaran akan tercatat dalam sistem.

### Melihat Riwayat Pembayaran

1. Pilih menu *Riwayat Pembayaran* untuk melihat daftar pembayaran yang telah dilakukan oleh mahasiswa.
2. Tabel akan menampilkan NIM, nama, jurusan, angkatan, dan jumlah yang dibayarkan oleh mahasiswa.

## Pengembangan Selanjutnya

Beberapa fitur yang dapat dikembangkan lebih lanjut:

1. Fitur Penyimpanan Data 
   Implementasi penyimpanan data ke dalam file (misalnya file JSON atau database) agar data tidak hilang saat aplikasi ditutup.

2. Autentikasi Pengguna  
   Menambahkan sistem login untuk membatasi akses ke aplikasi bagi pengguna tertentu.

3. Pengelolaan Pembayaran  
   Fitur untuk mengatur jenis pembayaran atau biaya tambahan.

## Kontribusi

Jika Anda ingin berkontribusi pada proyek ini, silakan lakukan fork dan kirimkan pull request. Kami akan dengan senang hati menerima kontribusi Anda.
---

Terima kasih telah menggunakan Aplikasi Pembayaran NIM!