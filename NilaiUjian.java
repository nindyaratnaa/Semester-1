/*Ucup akhir-akhir ini selalu disibukkan dengan pengembangan aplikasi 
ojek online UB-JEK sehingga Ucup kesulitan menghitung nilai akhir mahasiswanya. 
Sebagai mahasiswa yang baik, kalian menawarkan diri membuatkan program untuk 
menghitung nilai akhir dengan rumus perhitungan sebagai berikut.
- 10% tugas
- 20% kuis
- 30% UTS
- 30% UAS
- 10% keaktifan*/

import java.util.Scanner;
public class NilaiUjian {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //mengambil input nama mahasiswa menggunakan method namaMahasiswa
        String nama = namaMahasiswa(input);

        //mengambil nilai tugas, kuis, UTS, UAS, dan aktif dengan menggunakan method nilailMahasiswa
        double tugas = nilaiMahasiswa("Tugas", input);
        double kuis = nilaiMahasiswa("Kuis", input);
        double UTS = nilaiMahasiswa("UTS", input);
        double UAS = nilaiMahasiswa("UAS", input);
        double aktif = nilaiMahasiswa("Aktif", input);
        
        //menghitung nilai akhir dengan menggunakan method penghitunganNilai
        double hasil = penghitunganNilai(tugas, kuis, UTS, UAS, aktif);
        
        //menampilkan hasil nilai akhir dengan menggunakan method printHasil
        printHasil(nama, hasil);
    }

    //method untuk membaca input nama
    public static String namaMahasiswa (Scanner input) {
        System.out.print("Masukkan nama: ");
        return input.nextLine();  // Mengembalikan nama yang dimasukkan
    }

    //method untuk membaca input nilai (tugas, kuis, UTS, UAS, aktif)
    public static double nilaiMahasiswa (String jenis, Scanner input) {
        System.out.print("Masukkan nilai " + jenis + ": ");
        return input.nextDouble();  // Mengembalikan nilai yang dimasukkan
    }

    //method untuk menghitung nilai akhir berdasarkan bobot yang diberikan
    public static double penghitunganNilai(double tugas, double kuis, double UTS, double UAS, double aktif) {
        // Menghitung nilai akhir berdasarkan rumus
        return (tugas * 0.1) + (kuis * 0.2) + (UTS * 0.3) + (UAS * 0.3) + (aktif * 0.1);
    }

    //method untuk menampilkan hasil nilai akhir
    public static void printHasil(String nama, double hasil) {
        // Menampilkan hasil dengan format dua angka desimal
        System.out.printf("Nilai akhir %s adalah %.2f%n", nama, hasil);
    }
}
