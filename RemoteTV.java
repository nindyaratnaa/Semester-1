/*eorang teknisi sedang memperbaiki sebuah Remote Control di rumah pelanggan. 
Remote Control tersebut memiliki beberapa tombol fungsi utama yang digunakan untuk mengoperasikannya. 
Teknisi ingin memastikan bahwa setiap tombol bekerja dengan baik, jadi ia membuat sebuah program 
yang menyimulasikan respon dari setiap tombol berdasarkan input nomor yang dimasukkan oleh pengguna.

Tombol-tombol yang tersedia adalah sebagai berikut:
1. ON - Akan menampilkan pesan "Perangkat Dinyalakan."
2. OFF - Akan menampilkan pesan "Perangkat Dimatikan."
3. PAUSE - Akan menampilkan pesan "Tayangan Berhenti."
4. PREV - Akan menampilkan pesan "Channel Sebelumnya."
5. NEXT - Akan menampilkan pesan "Channel Berikutnya."
6. Default - Akan menampilkan pesan "-".

Program tersebut akan meminta pengguna untuk memasukkan nomor antara 1 hingga 5, 
dan kemudian program akan menampilkan fungsi yang sesuai dengan tombol tersebut.*/

import java.util.Scanner;
public class RemoteTV {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        //settingan channel agar nanti tidak ada kejadian channel -1
        int channel = 0;
        int channelMin = 0;
        int channelMax = 15;

        //settingan volume agar tidak melampaui nilali max dan min
        int volume = 50;
        int volumemin = 0;
        int volumemax = 100;

        System.out.println("TV dinyalakan");            
        System.out.println("Tombol remot TV");
        System.out.println("1 : Naik channel");
        System.out.println("2 : Turun channel");
        System.out.println("3 : Naik volume");
        System.out.println("4 : Turun volume");
        System.out.println("0 : Matikan TV");

        while(true){
            System.out.println();
            System.out.println("Masukkan angka tombol yang ingin ditekan: ");
            int tombol = input.nextInt();
   
            switch (tombol) {
                case 1 : //jika input "1" akan memproses channel 
                    if (channel < channelMax){ //jika channel belum mencapai max akan di tambahkan
                        channel++;
                    }
                    System.out.println("Channel sekarang no-" + channel);
                    break;
                case 2 : //jika input "2" akan memproses channel 
                    if (channel > channelMin){ //jika channel belum mencapai min akan di tambahkan
                        channel--;
                    }
                    System.out.println("Channel sekarang no-" + channel);
                    break;
                case 3 : //jika input "3" akan memproses volume 
                    if (volume < volumemax){ //jika volume belum mencapai max akan di tambahkan
                        volume += 10;
                    }
                    System.out.println("Volume sekarang " + volume);
                    break;
                case 4 : //jika input "4" akan memproses volume 
                    if (volume > volumemin){ //jika volume belum mencapai min akan di tambahkan
                        volume -= 10;
                    }
                    System.out.println("Volume sekarang " + volume);
                    break;
                case 0 : //jika input "0" maka tv akan mati 
                    System.out.println("TV dimatikan");
                    System.exit(0);
                    input.close();
                    break;
                default :
                    System.out.println("Tidak terdapat tombol nomor " + tombol);
            }

        }
    }
}