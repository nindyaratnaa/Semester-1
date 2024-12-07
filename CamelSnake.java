/*Dalam pemrograman, ada 2 gaya penulisan untuk variabel, yaitu camel case dan snake case. 
Tugas kalian adalah mengubah input  yang menggunakan konvensi camelCase menjadi snake_case. 

Input Format
1 baris berisi string 
Constraints
S berisi alphanumeric dan tidak ada spasi

Output Format
Hasil konversi snake_case

Sample Input 0
camelCase

Sample Output 0
camel_case*/

import java.util.Scanner;
public class CamelSnake {
    public static void main(String[] args) {
        //Membaca input dari STDIN
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        //StringBuilder untuk menyimpan hasil konversi
        StringBuilder result = new StringBuilder();
        
        //Iterasi melalui setiap karakter dalam input
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            //Jika karakter adalah huruf kapital
            if (Character.isUpperCase(c)) {
                //Tambahkan underscore sebelum huruf kapital dan ubah ke huruf kecil
                if (i != 0) {  //Pastikan bukan karakter pertama
                    result.append("_");
                }
                result.append(Character.toLowerCase(c));
            } else {
                //Jika bukan huruf kapital, tambahkan karakter tersebut langsung
                result.append(c);
            }
        }

        //Mencetak hasil konversi ke snake_case
        System.out.println(result.toString());

        //Menutup scanner
        scanner.close();
    }
}
