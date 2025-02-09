import java.util.Scanner;
public class projectAkhir {
    public static void main(String[] args) {
        // Deklarasi nama barang dan harga
        String[] namaBarang = {"buku tulis", "pensil", "rautan", "pulpen", "tempat pensil", "kertas HVS", "stabilo"};
        int[] hargaBarang = {10000, 5000, 15000, 8000, 25000, 30000, 7500};
        int[] totalBarang = new int[namaBarang.length]; // Menyimpan total barang yang dibeli

        Scanner input = new Scanner(System.in);

        // Menampilkan daftar barang dengan memanggil method
        tampilkanDaftarBarang();

        // Memproses pembelian
        prosesPembelian(namaBarang, hargaBarang, totalBarang, input);

        // Menampilkan struk dan menghitung total harga
        double hargaSemua = tampilkanStruk(namaBarang, hargaBarang, totalBarang);

        // Menghitung dan menampilkan diskon
        double hargaDiskon = hitungDiskon(hargaSemua);
        System.out.printf("\n%-14s: Rp.%,.2f", "Pembayaran", hargaDiskon);

        // Menampilkan pesan terima kasih
        System.out.println("\n-------------------------------- ");
        System.out.println("  Terimakasih telah berbelanja ");
        System.out.println("================================ ");
    }

    // Menampilkan daftar barang beserta harga
    public static void tampilkanDaftarBarang() {
        System.out.println("\n================================ ");
        System.out.printf("%10s%s%10s", " ", "TOKO PEMDAS", " ");
        System.out.printf("\n245150700111001 Anindya Ratna P.");
        System.out.println("\n================================ ");
        System.out.println("List barang : ");
        System.out.println("-------------------------------- ");
        System.out.printf("%-15s%s%5s%11s", "buku tulis", ":", "Rp", "10.000,00");
        System.out.printf("\n%-15s%s%5s%11s", "pensil", ":", "Rp", "5.000,00");
        System.out.printf("\n%-15s%s%5s%11s", "rautan", ":", "Rp", "15.000,00");
        System.out.printf("\n%-15s%s%5s%11s", "pulpen", ":", "Rp", "8.000,00");
        System.out.printf("\n%-15s%s%5s%11s", "tempat pensil", ":", "Rp", "25.000,00");
        System.out.printf("\n%-15s%s%5s%11s", "kertas HVS", ":", "Rp", "30.000,00");
        System.out.printf("\n%-15s%s%5s%11s", "stabilo", ":", "Rp", "7.500,00");
        System.out.println("\n================================ ");
    }

    // Memproses input pembelian dan mengumpulkan data barang yang dibeli
    public static void prosesPembelian(String[] namaBarang, int[] hargaBarang, int[] totalBarang, Scanner input) {
        System.out.println("\nMulai memasukkan barang belanjaan");
        System.out.println("Ketik 'stop' untuk berhenti"); // Kode untuk berhenti input barang

        while (true) {
            System.out.println(); // Memberi jarak sebelum penginputan
            System.out.print("Nama barang: ");
            String NBarang = input.nextLine(); // Input nama barang

            if (NBarang.equalsIgnoreCase("stop")) {
                break; // Menghentikan input barang
            }

            System.out.print("Jumlah barang: ");
            int JumBarang = Integer.parseInt(input.nextLine()); // Input jumlah barang

            boolean barangTersedia = false;
            for (int i = 0; i < namaBarang.length; i++) {
                if (namaBarang[i].equalsIgnoreCase(NBarang)) {
                    totalBarang[i] += JumBarang; // Menambahkan jumlah barang yang dibeli
                    barangTersedia = true;
                    break; // Keluar dari loop
                }
            }
            if (!barangTersedia) { // Jika tidak tersedia akan menampilkan kata
                System.out.println("Barang tidak diketahui, masukkan ulang.");
            }
        }
    }

    // Menampilkan struk belanja dan menghitung total harga
    public static double tampilkanStruk(String[] namaBarang, int[] hargaBarang, int[] totalBarang) {
        System.out.println("\n================================ ");
        System.out.printf("%10s%s%10s", " ", "TOKO PEMDAS", " ");
        System.out.printf("\n245150700111001 Anindya Ratna P.");
        System.out.println("\n================================ ");
        System.out.printf("%-14s%s", "Nama Barang", "Harga");
        System.out.printf("\n-------------------------------- ");
        
        double hargaSemua = 0; // Inisiasi nilai total harga

        // Menampilkan rincian barang yang dibeli dan menghitung total harga
        for (int i = 0; i < namaBarang.length; i++) {
            if (totalBarang[i] > 0) {
                double totalHarga = totalBarang[i] * hargaBarang[i]; 
                System.out.printf("\n%-14s: Rp.%,.2f", namaBarang[i], totalHarga); // Menampilkan harga per barang
                hargaSemua += totalHarga; // Menambahkan ke total harga
            }
        }

        System.out.print("\n-------------------------------- ");
        System.out.printf("\n%-14s: Rp.%,.2f", "Total", hargaSemua); // Menampilkan total harga sebelum diskon
        return hargaSemua; // Mengembalikan total harga
    }

    // Menghitung diskon berdasarkan total belanja
    public static double hitungDiskon(double hargaSemua) {
        double hargaDiskon;
        
        if (hargaSemua >= 100000) { // Mendapat diskon 20% bila total harga lebih dari 100.000
            hargaDiskon = hargaSemua - (hargaSemua * 0.20);
            System.out.printf("\n%-14s: 20%%", "Diskon");
        } else if (hargaSemua >= 50000) { // Mendapat diskon 10% bila total harga lebih dari 50.000
            hargaDiskon = hargaSemua - (hargaSemua * 0.10);
            System.out.printf("\n%-14s: 10%%", "Diskon");
        } else { // Tidak mendapat diskon
            hargaDiskon = hargaSemua;
        }
        
        return hargaDiskon; // Mengembalikan harga setelah diskon
    }
}
