/*Ucupman adalah seorang superhero baru yang berasal dari kota Malang. 
Berhubung akan ada reuni para pahlawan, Ucup membutuhkan seragam kepahlawanan berlogo huruf di dadanya. 
Bantulah Ucupman mendesain seragam kepahlawanannya.
Huruf pada seragam Ucupman memiliki ukuran yaitu panjang, lebar, ketebalan garis. 
Gambar diatas adalah contoh yang berukuran lebar 9 huruf, panjang 8 huruf dan ketebalan 3 huruf.

Input Format
Satu baris berisi integer lebar l, panjang p, dan ketebalan k yang dipisahkan satu spasi.

Constraints
l > 2 * k
p > k
p > 2
l < 12
k < 5

Output Format
p baris susunan huruf "U" yang membentuk huruf U sesuai permintaan Ucupman

Sample Input 0
3 3 1
Sample Output 0
U U
U U
UUU
Explanation 0
Logo U dengan lebar 3 huruf, panjang 3 huruf, dan ketebalan 1 huruf*/

import java.util.Scanner;

public class Ucupman {
    public static void main(String[] args) {
        //Membaca input dari pengguna
        Scanner input = new Scanner(System.in);
        System.out.println("Lebar: ");
        int l = input.nextInt(); //Lebar
        System.out.println("Panjang");
        int p = input.nextInt(); //Panjang
        System.out.println("Tebal");
        int k = input.nextInt(); //Ketebalan
        
        //Loop untuk mencetak logo "U"
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < l; j++) {
                //Cek apakah berada di bagian kiri atau kanan dengan ketebalan k
                if (j < k || j >= l - k) {
                    System.out.print("U");
                }
                //Cek apakah berada di bagian bawah dengan ketebalan k
                else if (i >= p - k) {
                    System.out.print("U");
                }
                else {
                    System.out.print(" ");
                }
            }
            //Pindah ke baris berikutnya
            System.out.println();
        }

        input.close();
    }
}

