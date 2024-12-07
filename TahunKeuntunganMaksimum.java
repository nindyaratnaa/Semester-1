/*Setiap tanggal 17 Agustus, Kota Yokto mengadakan perlombaan 17-an sebagai wujud 
merayakan ulang tahun kemerdekaan Negara Indonesia. Setiap tahunnya, Kota Yokto bisa 
mendapatkan untung ataupun rugi dari pelaksanaan lomba tersebut. Pada perlombaan 17-an 
tahun ini (2024), Anda dipilih sebagai sekretaris untuk mengelola segala aspek keuangan. 
Anda ingin menentukan cara pengelolaan uang yang efektif agar tahun ini Kota Yokto dapat 
mendapat keuntungan dari perlombaan 17-an.

Anda memiliki data keuntungan (dalam Juta) untuk beberapa tahun terakhir. 
Anda pun ingin menentukan, rentang tahun manakah yang penghasilannya maksimum, 
sehingga Anda bisa mengikuti cara pengelolaan uangnya agar keuntungan tahun ini bisa maksimal.
Jika tidak ada keuntungan (semua nilai negatif), cukup keluarkan angka "0".

Input Format
Baris pertama, bilangan bulat n (1 ≤ n ≤ 100), jumlah data keuntungan yang tersedia.
Baris kedua, n bilangan bulat yang merepresentasikan keuntungan (positif) atau kerugian (negatif) untuk setiap tahun.

Constraints
Tahun pertama dalam data adalah 2024 − n. Misalnya data ada 5, seperti [2, -7, 10, -1, 20], maka tahun pertamanya adalah 2019.

Output Format
Rentang tahun dengan keuntungan total maksimum dalam format tahun_awal-tahun_akhir.
Jika tidak ada keuntungan (semua nilai negatif), keluarkan angka "0".*/

import java.util.Scanner;
public class TahunKeuntunganMaksimum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Membaca jumlah data keuntungan
        System.out.println("Banyak data: ");
        int n = input.nextInt();
        int[] keuntungan = new int[n];

        //Membaca data keuntungan per tahun
        for (int i = 0; i < n; i++) {
            keuntungan[i] = input.nextInt();
        }

        //Variabel untuk menyimpan hasil
        int maxSum = 0;
        int currentSum = 0;
        int start = 0;
        int end = -1;
        int tempStart = 0;

        //Kadane's Algorithm untuk mencari subarray dengan keuntungan maksimum
        for (int i = 0; i < n; i++) {
            currentSum += keuntungan[i];

            //Jika currentSum lebih besar dari maxSum, update maxSum dan rentang tahun
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            //Jika currentSum menjadi negatif, mulai subarray baru
            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        //Jika tidak ada keuntungan, outputkan 0
        if (end == -1) {
            System.out.println(0);
        } else {
            //Menghitung tahun awal dan akhir berdasarkan indeks
            int tahunAwal = 2024 - n + start;
            int tahunAkhir = 2024 - n + end;
            System.out.println(tahunAwal + "-" + tahunAkhir);
        }

        input.close();
    }    
}
