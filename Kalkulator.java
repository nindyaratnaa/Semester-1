/*Kamu sebagai programmer handal dipaksa membantu oleh adik kamu. 
Sebagai kakak yang baik, buatlah program kalkulator sederhana yang bisa
memproses beberapa operasi sesuai dengan ketentuan sebagai berikut : Ada beberapa perintah 
1. "TAMBAH" = Menambah total dengan angka baru dan mencetaknya 
2. "KURANG" = Mengurang total dengan angka baru dan mencetaknya 
3. "KALI" = Mengali total dengan angka baru dan mencetaknya 
4. "BAGI" = Membagi total dengan angka baru dan mencetaknya 
5. "SELESAI" = Mencetak total dan perulangan selesai 
6. Selain perintah di atas, akan mencetak total*/

import java.util.Scanner;
public class Kalkulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float angka = 0, a = angka;
        String operator;

        for (int i = 0; i <= i; i++) {
            System.out.println("Masukkan operasi matematika (OPERATOR ANGKA): ");
            operator = input.next();
            if (operator.equals("SELESAI")) {
                System.out.println(angka);
                break;
            }

            a = input.nextFloat();
            switch (operator) {
                case "TAMBAH":
                    angka += a;
                    break;
                case "KURANG":
                    angka -= a;
                    break;
                case "KALI":
                    angka *= a;
                    break;
                case "BAGI":
                    angka /= a;
                    break;
                default:
                    break;

            }
            System.out.println(angka);
        }
        input.close();
    }

}