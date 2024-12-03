/*Adik kamu yang manis sekarang mendapat tugas baru dari gurunya.
Lagi lagi kamu disuruh membantu karena kamu adalah programmer hebat.
Tugasnya adalah, diberikan suatu angka (angka biasa/desimal/pecahan/pecahan campuran),
ubahlah angka tersebut menjadi bentuk desimal, pecahan, dan pecahan campuran. 
Bantulah adik kamu dengan membuat program dengan ketentuan di atas sesuai dengan output format.

Ada beberapa hal yang perlu diperhatikan!
Jika angka merupakan bilangan 0 maka outputnya adalah:
Desimal: 0
Pecahan campuran: 0
Pecahan: 0

Jika angka merupakan bilangan bulat maka outputnya adalah:
Desimal: 15.0
Pecahan campuran: 15.0
Pecahan: 15.0*/

import java.util.Scanner;
public class UbahAngka {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        System.out.println("Masukkan angka (angka biasa/desimal/pecahan/campuran): ");
        String angka = input.nextLine().trim(); //input dari user dan menghapus spasi di awal/akhir
        input.close();

        System.out.println(prosesAngka(angka));  //menampilkan hasil perubahan angka yang diproses dengan memanggil method
    }

    public static String prosesAngka(String angka) {
        //jika input adalah 0, langsung kembalikan hasilnya
        if (angka.equals("0")) {
            return "Desimal: 0\nPecahan campuran: 0\nPecahan: 0";
        }

        double nilaiDesimal = 0.0; //inisiasi nilai variabel untuk menyimpan nilai desimal
        int pembilang = 0, penyebut = 1; //variabel untuk menyimpan pembilang dan penyebut pecahan
        int bulat = 0; //variabel untuk menyimpan bagian bulat (seluruh angka sebelum koma)

        //jika input pecahan campuran (5 1/2)
        if (angka.contains(" ") && angka.contains("/")) {
            String[] bagian = angka.split(" "); //memisahkan bagian bulat dan pecahan
            bulat = Integer.parseInt(bagian[0]); //bagian bulat (angka sebelum spasi)
            String[] bagianPecahan = bagian[1].split("/"); //memisahkan pembilang dan penyebut pecahan
            pembilang = Integer.parseInt(bagianPecahan[0]);
            penyebut = Integer.parseInt(bagianPecahan[1]);
            nilaiDesimal = bulat + (double) pembilang / penyebut; //menghitung nilai desimal dari pecahan campuran
            pembilang = bulat * penyebut + pembilang; //mengonversi pecahan campuran ke pecahan biasa
        } 
        //jika input pecahan (5/2)
        else if (angka.contains("/")) {
            String[] bagianPecahan = angka.split("/"); //memisahkan pembilang dan penyebut
            pembilang = Integer.parseInt(bagianPecahan[0]);
            penyebut = Integer.parseInt(bagianPecahan[1]);
            nilaiDesimal = (double) pembilang / penyebut; //menghitung nilai desimal dari pecahan
        } 
        //jika input angka desimal biasa (9.5)
        else {
            nilaiDesimal = Double.parseDouble(angka); //mengonversi input menjadi angka desimal
            String pecahanString = kePecahan(nilaiDesimal); //engonversi angka desimal ke pecahan
            String[] bagianPecahan = pecahanString.split("/"); //memisahkan pembilang dan penyebut
            pembilang = Integer.parseInt(bagianPecahan[0]);
            penyebut = Integer.parseInt(bagianPecahan[1]);
        }

        //menyederhanakan pecahan
        int fpb = fpb(pembilang, penyebut); //menemukan FPB untuk penyederhanaan
        pembilang /= fpb;
        penyebut /= fpb;

        String pecahanCampuran;
        //mengonversi pecahan biasa menjadi pecahan campuran 
        if (pembilang >= penyebut) {
            bulat = pembilang / penyebut; //bagian bulat dari pecahan
            int sisa = pembilang % penyebut; //sisa pembagian
            pecahanCampuran = sisa == 0 
                ? String.format("%.1f", (double) bulat) //jika tidak ada sisa, hanya tampilkan bagian bulat
                : bulat + " " + sisa + "/" + penyebut; //menampilkan pecahan campuran
        } else {
            pecahanCampuran = pembilang + "/" + penyebut; //pecahan biasa
        }

        //jika pembilang % penyebut = 0; angka bulat
        if (pembilang % penyebut == 0) {
            double angkaBulat = (double) pembilang / penyebut;
            return "Desimal: " + nilaiDesimal + 
                   "\nPecahan campuran: " + String.format("%.1f", angkaBulat) + 
                   "\nPecahan: " + String.format("%.1f", angkaBulat);
        }

        return "Desimal: " + nilaiDesimal + 
               "\nPecahan campuran: " + pecahanCampuran + 
               "\nPecahan: " + pembilang + "/" + penyebut;
    }

    //fungsi untuk mencari FPB (Faktor Persekutuan Terbesar)
    public static int fpb(int a, int b) {
        if (b == 0) return a;
        return fpb(b, a % b);
    }

    //fungsi untuk mengonversi angka desimal menjadi pecahan
    public static String kePecahan(double desimal) {
        int penyebut = 1;
        while (desimal * penyebut % 1 != 0) { //menyusun penyebut agar desimal menjadi bilangan bulat
            penyebut *= 10;
        }
        int pembilang = (int) (desimal * penyebut); //mengonversi desimal menjadi pembilang
        return pembilang + "/" + penyebut; //mengembalikan sebagai string pecahan
    }
}
