/*Buatlah program yang mencetak semua bilangan prima antara dua angka a dan b (termasuk).*/

import java.util.Scanner;
public class BilanganPrima {
    public static void main (String[] args) {
        //scanner agar input dpt terbaca
    Scanner input = new Scanner(System.in);

    //declare tipe data dan inputan
        System.out.print("Masukkan batas awal: ");
        int a = input.nextInt();
        System.out.print("Masukkan batas akhir: ");
        int b = input.nextInt();
        input.close();
        
    //menggunakan loop for untuk output tiap bil i mulai "a" sampai "b"
        for (int i = a; i <= b; i++) {
            boolean prima = true; // prima = true agar program berjalan
            if (i < 2) {
                prima = false; // jika bil < 2 false (bukan prima)
            } 
            else {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        prima = false; // tiap bil i yang habis dibagi 2 hingga bil (i-1), bukan prima
                        break; //keluar dari loop
                    }
                } 
                if (prima) {
                    System.out.print(i); //print bil prima
                    System.out.print(" "); //print spasi
                }
            }
        }
    
    
    }
}

