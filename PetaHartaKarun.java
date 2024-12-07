/*Anda sedang memainkan sebuah permainan mencari harta karun di peta 2D berukuran 3×3. 
Setiap lokasi pada peta memiliki nilai:
1: Menandakan ada harta karun. 
0: Menandakan area kosong tanpa harta karun.

Pencarian dimulai dari posisi (0,0) di sudut kiri atas peta, dan Anda dapat melakukan langkah-langkah berikut:
1: Bergerak ke atas jika memungkinkan.
2: Bergerak ke bawah jika memungkinkan.
3: Bergerak ke kiri jika memungkinkan.
4: Bergerak ke kanan jika memungkinkan.
Tugas Anda adalah menentukan apakah Anda berhasil menemukan harta karun atau tidak setelah semua langkah dilakukan.

Input Format
Sebuah matriks 3×3 yang merepresentasikan peta (setiap elemen adalah 0 atau 1).
Bilangan bulat n (jumlah langkah, 1 ≤ n ≤10).
n bilangan bulat berikutnya yang merepresentasikan langkah (1: Atas, 2: Bawah, 3: Kiri, 4:Kanan).

Constraints
Peta selalu berukuran 3×3.
Nilai elemen peta hanya 0 atau 1.
Jika langkah keluar dari peta, maka dihiraukan

Output Format
"Harta Karun ditemukan!" jika posisi terakhir Anda berada di lokasi dengan nilai 1.
"Yah tidak ketemu" jika posisi terakhir Anda berada di lokasi dengan nilai 0*/

import java.util.Random;
import java.util.Scanner;
public class PetaHartaKarun {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random acak = new Random();
        
        //Membaca peta 3x3 (matriks 2D)
        int[][] peta = new int[3][3];  //Matriks 3x3 untuk peta
        for (int i = 0; i < 3; i++) {  //Loop untuk membaca 3 baris peta
            for (int j = 0; j < 3; j++) {  //Loop untuk membaca 3 kolom pada setiap baris
                peta[i][j] = acak.nextInt(2);  //Menghasilkan angka 0 atau 1 secara acak
            }
        }
        
        //Membaca jumlah langkah yang akan dilakukan
        System.out.println("Pencarian dimulai dari posisi (0,0) di sudut kiri atas peta");
        System.out.println("1: Bergerak ke atas jika memungkinkan.");
        System.out.println("2: Bergerak ke bawah jika memungkinkan.");
        System.out.println("3: Bergerak ke kiri jika memungkinkan.");
        System.out.println("4: Bergerak ke kanan jika memungkinkan.");
        System.out.println("Masukkan langkah: ");
        int n = input.nextInt();  //Membaca jumlah langkah yang diinginkan
        
        //Membaca langkah-langkah yang akan diambil (angka 1-4 untuk gerakan)
        int[] langkah = new int[n];  //Array untuk menyimpan langkah-langkah yang dimasukkan
        for (int i = 0; i < n; i++) {  //Loop untuk membaca langkah-langkah
            langkah[i] = input.nextInt();  //Menyimpan langkah ke dalam array
        }
        
        //Posisi awal berada di (0, 0), sudut kiri atas peta
        int x = 0, y = 0;  //Koordinat posisi pemain, mulai dari 0,0

        //Mengikuti langkah-langkah yang diberikan
        for (int i = 0; i < n; i++) {  //Loop untuk setiap langkah yang diberikan
            int gerakan = langkah[i];  //Mengambil langkah saat ini
            
            //Memeriksa jenis gerakan dan memperbarui posisi
            if (gerakan == 1 && x > 0) {  //Jika langkah 1 (gerakan ke atas)
                x--;  //Pindah ke atas (kurangi nilai x)
            } else if (gerakan == 2 && x < 2) {  //Jika langkah 2 (gerakan ke bawah)
                x++;  //Pindah ke bawah (tambah nilai x)
            } else if (gerakan == 3 && y > 0) {  // Jika langkah 3 (gerakan ke kiri)
                y--;  //Pindah ke kiri (kurangi nilai y)
            } else if (gerakan == 4 && y < 2) {  // Jika langkah 4 (gerakan ke kanan)
                y++;  //Pindah ke kanan (tambah nilai y)
            }
            //Jika langkah keluar dari peta (misalnya bergerak ke luar batas), maka tidak ada perubahan posisi
        }
        
        //Cek apakah posisi akhir mengandung harta karun (nilai 1 pada peta)
        if (peta[x][y] == 1) {  //Jika di posisi (x, y) ada harta karun
            System.out.println("Harta Karun ditemukan!");  //Menampilkan pesan jika harta ditemukan
        } else {
            System.out.println("Yah tidak ketemu");  //Menampilkan pesan jika tidak ada harta karun
        }
        
        //Menutup scanner setelah selesai membaca input
        input.close();
    }
}