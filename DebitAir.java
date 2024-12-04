/*Sebuah keran air digunakan untuk mengisi sebuah ember dengan volume Y ml dalam X detik.
Jika keran air tersebut tidak diubah kecepatannya (ml/detik), apakah dapat memenuhi ember 
dengan volume 1500ml dalam 20 detik atau kurang?
1. Jika tidak, maka akan muncul pesan "Keran dengan kecepatan [kecepatan] ml/detik tidak cukup untuk mengisi ember"
2. Jika waktu yang diperlukan untuk mengisi ember adalah tepat 20 detik, 
   maka akan muncul pesan "Keran dengan kecepatan [kecepatan] ml/detik pas untuk mengisi ember"
3. Jika waktu yang diperlukan kurang dari 20 detik, maka akan muncul pesan 
   "Keran dengan kecepatan [kecepatan] ml/detik lebih dari cukup untuk mengisi ember"

Bulatkan kecepatan yang ditampilkan pada output dibulatkan menjadi 2 angka di belakang koma.*/

import java.util.Scanner;
public class DebitAir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan waktu yang ingin dibandingkan: ");
        double waktu = input.nextDouble();//waktu yang dibandingkan
        System.out.print("Masukkan volume ember yang akan di isi: ");
        double volume = input.nextDouble();
        input.close();
        
        double debit = volume / waktu;
        double tWaktu = volume / debit;//total waktu yang di perlukan 
        
        Math.round(debit);
        
        if (tWaktu > waktu)
            {System.out.printf("Keran dengan kecepatan %.2f ml/detik tidak cukup untuk mengisi ember", debit);}

        if (tWaktu == waktu)
            {System.out.printf("Keran dengan kecepatan %.2f ml/detik pas untuk mengisi ember", debit);}

        if (tWaktu < waktu)
            {System.out.printf("Keran dengan kecepatan %.2f ml/detik pas untuk mengisi ember", debit);}
    }
}
