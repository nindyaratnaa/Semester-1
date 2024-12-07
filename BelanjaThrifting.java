/*Anda sedang mengembangkan sistem invoicing untuk toko thrifting. 
Toko ini memiliki empat merek dengan harga tetap. Setiap pelanggan dapat memilih 
beberapa item berdasarkan ID produk (maksimal 4 item). Diskon diberikan berdasarkan total belanja (subtotal):
- Diskon 10% jika subtotal lebih dari 200.000.
- Diskon 5% jika subtotal lebih dari 150.000.
Tugas Anda adalah menampilkan struk pembelian yang memuat daftar item yang dibeli, subtotal, besaran diskon, dan total pembayaran.

Data baju :
ID 1 : ThriftCo: 50,000
ID 2 : VintageStyle: 75,000
ID 3 : FreshLook: 60,000
ID 4 : EcoWear: 90,000

Input Format
Baris pertama adalah bilangan bulat n (jumlah item yang dibeli, 1 ≤ n ≤ 4).
Baris berikutnya berisi n bilangan bulat, masing-masing merupakan ID produk yang dipilih (1 ≤ ID ≤ 4).
Tidak ada ID yang tidak valid pada input.

Constraints
Jumlah item yang dibeli, 1 ≤ n ≤ 4.

Output Format
Struk pembelian dengan format berikut:
Daftar item yang dibeli, termasuk nomor urut, nama merek, dan harga (dalam format rupiah).
Subtotal, besaran diskon, dan total pembayaran, semua dalam format rupiah yang diformat dengan tanda koma.
Pastikan ada garis pemisah "--------------------" sebelum bagian subtotal, diskon, dan total.*/

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class BelanjaThrifting {
    //Harga produk berdasarkan ID
    static int[] harga = {50000, 75000, 60000, 90000};
    static String[] merek = {"ThriftCo", "VintageStyle", "FreshLook", "EcoWear"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Membaca jumlah item yang dibeli
        int n = scanner.nextInt();
        
        //Array untuk menyimpan ID produk yang dibeli
        int[] idProduk = new int[n];
        for (int i = 0; i < n; i++) {
            idProduk[i] = scanner.nextInt();
        }

        //Menampilkan struk pembelian
        printStruk(idProduk, n);

        scanner.close();
    }

    //Method untuk menampilkan struk pembelian
    public static void printStruk(int[] idProduk, int n) {
        System.out.println("=== Struk ===");
        
        //Menghitung subtotal
        int subtotal = hitungSubtotal(idProduk, n);
        
        //Menampilkan daftar item yang dibeli
        for (int i = 0; i < n; i++) {
            int id = idProduk[i] - 1; // Mengurangi 1 karena ID produk mulai dari 1
            System.out.printf("%d. %-12s %s\n", i + 1, merek[id], formatRupiah(harga[id]));
        }

        //Menghitung diskon
        int diskon = hitungDiskon(subtotal);

        //Menghitung total setelah diskon
        int total = subtotal - diskon;

        //Menampilkan garis pemisah
        System.out.println("--------------------");

        //Menampilkan subtotal, diskon, dan total
        System.out.println("Subtotal:       " + formatRupiah(subtotal));
        System.out.println("Diskon:         " + formatRupiah(diskon));
        System.out.println("Total:          " + formatRupiah(total));

        System.out.println("====================");
    }

    //Method untuk menghitung subtotal
    public static int hitungSubtotal(int[] idProduk, int n) {
        int subtotal = 0;
        for (int i = 0; i < n; i++) {
            int id = idProduk[i] - 1; //Mengurangi 1 karena ID produk mulai dari 1
            subtotal += harga[id];
        }
        return subtotal;
    }

    //Method untuk menghitung diskon berdasarkan subtotal
    public static int hitungDiskon(int subtotal) {
        int diskon = 0;
        if (subtotal > 200000) {
            diskon = (int) (0.1 * subtotal); // Diskon 10%
        } else if (subtotal > 150000) {
            diskon = (int) (0.05 * subtotal); // Diskon 5%
        }
        return diskon;
    }

    //Method untuk memformat angka ke dalam format rupiah
    public static String formatRupiah(int amount) {
        //Format angka ke dalam format rupiah (contoh: 50,000)
        NumberFormat format = NumberFormat.getNumberInstance(new Locale("id", "ID"));
        return format.format(amount);
    }
}
