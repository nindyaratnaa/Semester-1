/*Pak Lukas menemukan peta kuno yang berisi nama dari wilayah-wilayah yang tersusun seperti matrix. 
Ternyata salah satu wilayah tersebut merupakan petunjuk untuk menemukan harta karun.
Bantu Pak Lukas untuk dapat menemukan petunjuk menuju wilayah dan posisis yang tepat pada peta.

Input Format
1. Input pertama digunakan untuk memasukan jumlah baris
2. Input kedua digunakan untuk memasukan jumlah kolom
3. Input ketiga digunakan untuk memasukan nama - nama wilayah yang tertera pada peta
4. Input terakhir digunakan untuk memasukan petunjuk/target wilayah yang tepat

Constraints
Baris < 10 Kolom < 10

Output Format
Kalau target ditemukan: "Target wilayah [target] ditemukan! Segera menuju daerah [index]"
Kalau target tidak ditemukan: "Wilayah [target] tidak ditemukan, peta invalid!"*/

import java.util.Scanner;
public class MencariPetunjuk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Membaca jumlah baris dan kolom peta
        System.out.println("Masukkan jumlah baris: ");
        int baris = input.nextInt();
        System.out.println("Masukkan jumlah kolom: ");
        int kolom = input.nextInt();
        input.nextLine();  //Untuk membersihkan newline setelah membaca angka

        //Membaca peta sebagai array 2D
        String[][] peta = new String[baris][kolom];
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                peta[i][j] = input.next();
            }
        }

        //Membaca nama wilayah target
        System.out.println("Masukkan wilayah target: ");
        String target = input.next();

        //Mencari target pada peta
        boolean ditemukan = false;
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                if (peta[i][j].equals(target)) {
                    //Jika ditemukan, tampilkan posisi
                    System.out.println("Target wilayah " + target + " ditemukan! Segera menuju daerah " + i + "," + j);
                    ditemukan = true;
                    break;
                }
            }
            if (ditemukan) {
                break;
            }
        }

        //Jika tidak ditemukan, tampilkan pesan error
        if (!ditemukan) {
            System.out.println("Wilayah " + target + " tidak ditemukan, peta invalid!");
        }

        input.close();
    }
}

