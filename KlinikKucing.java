/*Sebuah klinik kucing ingin meminta bantuan dari kalian untuk dibuatkan sebuah program 
yang dapat memonitor kesehatan kucing-kucing yang terdapat di klinik. 
Staff dari klinik tersebut perlu memasukkan nama, berat badan, dan suhu dari setiap kucing.

Adapun beberapa kondisi yang menandakan bahwa seekor kucing tidak sehat:
1. Suhu < 38 derajat celcius atau suhu > 39 derajat celcius
2. Berat badan < 3 kg atau berat badan > 6 kg

Jika semua kucing di klinik sehat, maka program akan menampilkan kalimat:
1. Semua kucing di klinik dalam kondisi sehat.
2. Jika terdapat kucing yang tidak sehat, maka program akan menampilkan jumlah kucing yang tidak sehat
   beserta rincian kondisinya yang membuatnya kurang sehat.

Note : Jika kucing dimasukkan dengan urutan: A, B, C, maka kondisi kucing yang kurang sehat yang dicetak
terlebih dahulu adalah kucing A, lalu B, baru C.*/

import java.util.*;
public class KlinikKucing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah kucing: ");
        int jumlah = input.nextInt(); //Memasukkan input jumlah kucing
        System.out.println();
        
        String[] NamaKucing = new String[jumlah]; //array nama kucing
        float[] BeratBadan = new float[jumlah]; //array berat kucing
        float[] SuhuBadan = new float[jumlah]; //array suhu kucing
        boolean[] KondisiKucing = new boolean[jumlah]; //array bolean untuk kondisi kucing

        for (int i = 0; i < jumlah; i++) { //mengulang sebanyak jumlah kucing yang di inputkan
            input.nextLine();
            System.out.print("Nama kucing: ");
            NamaKucing[i] = input.nextLine();
            System.out.print("Suhu kucing: ");
            SuhuBadan[i] = input.nextFloat();
            System.out.print("Berat kucing: ");
            BeratBadan[i] = input.nextFloat();
            System.out.println();
        }
        input.close();

        int TidakSehat = 0; //inisiasi awal untuk kondisi kucing
        for (int i = 0; i < jumlah; i++) { 
            KondisiKucing[i] = KesehatanKucing(BeratBadan[i], SuhuBadan[i]); //memanggil method kesehatan kucng
            if (KondisiKucing[i] == false) {
                TidakSehat++; //menambahkan jumlah kucing yang tidak sehat
            }
        }

        if (TidakSehat > 0) { //loop untuk kucing yang tidak sehat
            System.out.println("Terdapat " + TidakSehat + " kucing yang tidak sehat:");
            for (int i = 0; i < jumlah; i++) { //menjelaskan kondisi kucing yang tidak sehat
                if (KondisiKucing[i] == false) {
                    KondisiSuhuKucing(SuhuBadan[i], NamaKucing[i]); //memanggil method suhu kucing
                    KondisiBeratKucing(BeratBadan[i], NamaKucing[i]); //memanggil method berat kucing
                }
            }
        } else {
            System.out.println("Semua kucing di klinik dalam kondisi sehat."); //print out bila kondisi kucing sehat semua
        }
    }

    public static boolean KesehatanKucing(float BeratBadan, float SuhuBadan) {
        boolean kondisi = true;
        if (BeratBadan < 3 || BeratBadan > 6) {
            kondisi = false;
        }
        if (SuhuBadan < 38 || SuhuBadan > 39) {
            kondisi = false;
        }

        return kondisi;

    }

    public static void KondisiSuhuKucing(float SuhuBadan, String NamaKucing) {
        if (SuhuBadan > 39) {
            System.out.println(NamaKucing + " memiliki suhu di atas normal.");
        } else if (SuhuBadan < 38) {
            System.out.println(NamaKucing + " memiliki suhu di bawah normal.");
        }
    }

    public static void KondisiBeratKucing(float BeratBadan, String NamaKucing) {
        if (BeratBadan < 3) {
            System.out.println(NamaKucing + " memiliki berat badan di bawah normal.");
        } else if (BeratBadan > 6) {
            System.out.println(NamaKucing + " memiliki berat badan di atas normal.");
        }
    }
}