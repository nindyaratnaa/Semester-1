/*Diberikan bilangan bulat positif n, balikan digit-digit dari bilangan tersebut dan cetak hasilnya*/

import java.util.Scanner;
public class ReverseNumber {
public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan bilangan positif: ");
        int angka = input.nextInt();
        

        int reverse = 0; //inisiasi hasil angka reverse

        if (angka < 0) {
            System.out.println("Tidak termasuk bilangan positif.");
            return;
        }

        while (angka > 0) {
            int satuan = angka % 10; //ambil angka satuan
            reverse = reverse * 10 + satuan; //mereverse angka
            angka /= 10; //menghapus angka terakhir
        }

        System.out.print("Hasil reverse: " + reverse);
    }   
}
