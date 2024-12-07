/*Sally's Beauty ingin mengotomatiskan sistem penagihannya. Sistem perlu menghitung total pembayaran
untuk pelanggan berdasarkan layanan yang dipilih, penawaran diskon, PPN (11%), dan admin fee sebesar 2000 
untuk pambayaran selain tunai atau bank mandiri.

Layanan yang diberikan Sally's Beauty yaitu:
Facial : 200000
Peeling : 350000
Botox : 500000
Diskon 30% diberikan untuk pelanggan yang membayar menggunakan bank mandiri dengan minimal pembayaran 250000.
Penawaran yang berlaku mulai tanggal 1 November 2023 - 7 November 2023*/

import java.util.Scanner;
public class SallyBeauty {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Input nama pelanggan
        System.out.println("Masukkan nama: ");
        String nama = input.nextLine();

        //Input tanggal transaksi
        System.out.println("Masukkan tanggal (1-30): ");
        int tanggal = input.nextInt();
        input.nextLine();  // Makan newline

        //Input layanan yang dipilih
        System.out.println("Masukkan layanan (Facial/Peeling/Botox): ");
        String layanan = input.nextLine();

        //Input metode pembayaran
        System.out.println("Masukkan Tunai/Bank Mandiri/Lainnya: ");
        String metodePembayaran = input.nextLine();

        //Input jumlah uang yang dibayarkan
        System.out.println("Masukkan uang yang dibayarkan: ");
        int uangDibayar = input.nextInt();

        //Menentukan harga layanan berdasarkan pilihan
        int hargaLayanan = 0;
        if (layanan.equalsIgnoreCase("Facial")) {
            hargaLayanan = 200000;
        } else if (layanan.equalsIgnoreCase("Peeling")) {
            hargaLayanan = 350000;
        } else if (layanan.equalsIgnoreCase("Botox")) {
            hargaLayanan = 500000;
        }

        //Menghitung total sebelum PPN dan diskon
        int total = hargaLayanan;

        //Menghitung diskon jika ada
        int diskon = hitungDiskon(total, metodePembayaran, tanggal);

        //Menghitung PPN
        int ppn = hitungPPN(total);

        //Menghitung admin fee jika ada
        int adminFee = hitungAdminFee(metodePembayaran);

        //Menampilkan laporan transaksi
        tampilkanLaporan(tanggal, nama, layanan, hargaLayanan, total, diskon, ppn, adminFee, metodePembayaran, uangDibayar);

        //Menutup scanner
        input.close();
    }



    //Method untuk menghitung PPN
    public static int hitungPPN(int total) {
        return (int) (total * 0.11); //11% PPN
    }

    //Method untuk menghitung diskon untuk Bank Mandiri
    public static int hitungDiskon(int total, String metodePembayaran, int tanggal) {
        //Diskon hanya berlaku untuk Bank Mandiri dan jika total >= 250000 serta tanggal 1-7 November
        if (metodePembayaran.equalsIgnoreCase("Bank Mandiri") && total >= 250000 && tanggal >= 1 && tanggal <= 7) {
            return (int) (total * 0.30); //30% diskon
        }
        return 0;
    }

    //Method untuk menghitung admin fee
    public static int hitungAdminFee(String metodePembayaran) {
        //Admin fee hanya berlaku untuk selain Bank Mandiri dan Tunai
        if (!metodePembayaran.equalsIgnoreCase("Tunai") && !metodePembayaran.equalsIgnoreCase("Bank Mandiri")) {
            return 2000; //Admin fee sebesar 2000
        }
        return 0;
    }

    //Method untuk menampilkan laporan transaksi
    public static void tampilkanLaporan(int tanggal, String nama, String layanan, int hargaLayanan, int total, int diskon, int ppn, int adminFee, String metodePembayaran, int uangDibayar) {
        System.out.println("      Sally's Beauty");
        System.out.println("==========================");
        System.out.println(tanggal + " November 2023\n");
        
        //Menampilkan detail layanan yang dipilih
        System.out.printf("Nama Pelanggan : %s\n", nama);
        System.out.printf("%-14s : %9d\n", layanan, hargaLayanan);
        System.out.println("--------------------------");
        
        //Menampilkan total sebelum PPN dan diskon
        System.out.printf("%-14s : %9d\n", "Total", total);
        System.out.println("--------------------------");
        
        //Menampilkan diskon, jika ada
        if (diskon > 0) {
            System.out.printf("%-14s : %9d\n", "Diskon (30%)", diskon);
        }

        //Menampilkan PPN
        System.out.printf("%-14s : %9d\n", "PPN (11%)", ppn);
        
        //Menampilkan admin fee, jika ada
        if (adminFee > 0) {
            System.out.printf("%-14s : %9d\n", "Admin Fee", adminFee);
        }
        
        //Menampilkan total bayar
        int totalBayar = total - diskon + ppn + adminFee;
        System.out.printf("%-14s : %9d\n", "Total Bayar", totalBayar);
        
        //Menampilkan metode pembayaran
        System.out.printf("%-14s : %9d\n", metodePembayaran, uangDibayar);
        System.out.println("--------------------------");

        //Menampilkan kembalian
        int kembalian = uangDibayar - totalBayar;
        System.out.printf("%-14s : %9d\n", "Kembalian", kembalian);
        System.out.println("==========================");
    }
}