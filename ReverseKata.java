/*Diberikan suatu kata, balikan kata tersebut untuk cek merupakan palindrome atau bukan*/

import java.util.Scanner;
public class ReverseKata {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //HURUF
        System.out.print("Masukkan kata: ");
        String kata = input.nextLine(); //input katanya
        input.close();
        
        int panjangKata = kata.length(); //untuk jumlah karakter dalam kata dan memecah tiap karakternya

        boolean PalindromeFlag = true; //harus true agar for bisa jalan

        for (int i=0; i<kata.length(); i++) {
            //index terakhir (kata length - 1 - i)
            int j = kata.charAt(kata.length() - 1 - i); //karakterkedua/terakhir
            int c = kata.charAt(i); //karakter pertama
        
            if (c != j) { //jika c tidak sama dengan j >> 'r'aceca'r' = r = r >> jika >> 'j'ik'a' = j != a
                System.out.println(kata + " bukan sebuah palindrome.");
                PalindromeFlag = false; //untuk memberhentikan perulangan
            break;
        }
    }

    if (PalindromeFlag) {  //kalau palindrome
    System.out.println(kata + " adalah sebuah palindrome.");
    }
    }
}
