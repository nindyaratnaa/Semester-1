/*Tugas anda sangatlah mudah namun sulit. 
Anda diberi bilangan n dan tentukan jumlah kotak pada barisan ke-n. 
n1 = 1
n2 = 5
n3 = 13
*/

import java.util.Scanner;
public class Geometri {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan nilai n: ");
        long n = input.nextLong();
        input.close();
        
        long a = 2;
        long b = -2;
        long c = 1;

        long hasil = a * n * n + b * n + c;
        System.out.println("Pada n = " + n + " bernilai " + hasil);
    }
}
