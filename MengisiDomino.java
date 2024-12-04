/*Anda diberi papan persegi panjang M × N. Anda juga diberi kartu domino standar 2 × 1 berjumlah tidak terbatas. 
Anda boleh memutar domino tersebut. Anda diminta untuk meletakkan sebanyak mungkin kartu domino di papan 
untuk memenuhi persyaratan berikut:
1. Setiap domino mencakup dua kotak.
2. Tidak ada dua kartu domino yang tumpang tindih.
3. Setiap domino terletak sepenuhnya di dalam papan. Diperbolehkan menyentuh tepi papan.
Tentukan jumlah maksimum kartu domino, yang dapat ditempatkan sesuai syarat tersebut.*/

import java.util.Scanner;
public class MengisiDomino {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan panjang: ");
        long M = input.nextLong();

        System.out.print("Masukkan lebar: ");
        long N = input.nextLong();
        input.close();
        
        long hasil = M * N / 2;
        
        System.out.print("Jumlah maksimum kartu domino pada papan adalah " + hasil);
    }
}
