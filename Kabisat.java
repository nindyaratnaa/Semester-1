/*Anto ingin membuat sebuah program yang dapat mengidentifikasi tahun kabisat. Bantulah Anto menciptakan program tersebut!*/

import java.util.Scanner;
public class Kabisat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan tahun: ");
        int tahun = input.nextInt();
        input.close();

        if (tahun % 4 == 0)
            {System.out.printf("Tahun %d adalah tahun kabisat.", tahun);}
        else 
            {System.out.printf("Tahun %d bukan tahun kabisat.", tahun);}
    }
}
