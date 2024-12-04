/*Anda diminta untuk membuat sebuah program pendaftaran peserta lomba di sebuah kompetisi teknologi. 
Kompetisi ini diadakan di dua kota, yaitu MALANG dan JAKARTA. 
Terdapat dua jenis lomba, yaitu Capture The Flag (CTF) dan Competitive Programming (CP). 
Peserta harus melakukan pendaftaran dan membayar biaya sesuai dengan tanggal pendaftaran dan jenis lomba yang dipilih.
Pendaftaran Lomba dibuka mulai tanggal 1-31 Oktober.

Berikut adalah ketentuan pendaftaran: 
1. Biaya pendaftaran adalah Rp 25.000. 
2. Jika peserta melakukan pendaftaran melebihi tanggal 15, 
   biaya pendaftaran akan dikenakan tambahan sebesar 10% dari biaya pendaftaran. 
3. Terdapat kode kota tempat lomba diadakan: Kode kota "MLG" untuk Malang. Kode kota "JKT" untuk Jakarta. 
   Apabila kode kota tidak sesuai, maka akan muncul output "Kode kota tidak valid."
4. Terdapat kode jenis lomba yang diadakan: Kode lomba "CTF" untuk lomba Capture The Flag. Kode lomba "CP" untuk lomba Competitive Programming. Apabila kode lomba tidak sesuai, maka akan muncul output "Kode lomba tidak valid." 6. Apabila tanggal yang dimasukkan tidak valid, akan muncul output "Tanggal tidak valid."

Buatlah program yang meminta input dari peserta berupa tanggal pendaftaran, kode kota, dan kode lomba.
Program harus menampilkan jenis lomba yang dipilih, kota tempat lomba diadakan, dan jumlah biaya yang harus dibayarkan sesuai dengan ketentuan di atas.*/

import java.util.Scanner;
public class PendaftaranLomba {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan tanggal pendaftaran (1-31): ");
        int tanggal = input.nextInt();
        input.nextLine();
        System.out.print("Masukkan temepat lomba (JKT/MLG): ");
        String tempat = input.nextLine();
        System.out.print("Masukkan kategori lomba (CP/CTF): ");
        String lomba = input.nextLine();    
        input.close();
        
        if (tanggal < 1 || tanggal > 31) {
            System.out.println("Tanggal tidak valid."); return;
        }
        
        
        int biaya = tanggal > 15 ? 27500 : 25000;

        if (tempat.equals("JKT")){
            tempat = "Jakarta"; 
        }
        else if (tempat.equals("MLG")){
            tempat = "Malang";
        }
        else {
            System.out.println("Kode kota tidak valid."); return;
        }
        
        if (lomba.equals("CP")){
            lomba = "Competitive Programming";
        }
        else if (lomba.equals("CTF")){
            lomba = "Capture The Flag";
        }
        else {
            System.out.println("Kode lomba tidak valid."); return;
        }
        
        
        System.out.printf("Peserta mengikuti Perlombaan " + lomba + " di " + tempat + "\nMohon lakukan pembayaran sebesar Rp." + biaya);


    }
}
