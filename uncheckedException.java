package exceptionHandling;

import java.util.Scanner;

public class uncheckedException {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        Exception: NumberFormatException
        System.out.println("\nContoh Kedua: NumberFormatException");
        System.out.print("Masukkan angka yang ingin diubah menjadi integer: ");

        String s = scan.nextLine(); // Misalnya kita memberi input karakter (a, b, c, d, e, ..., z)

        try {
            int i = Integer.parseInt(s); // Mengubah String menjadi int. Terjadi exception karena kita memberi input karakter dan bukannya angka
            System.out.println("Hasil konversi: " + i);
        } catch (NumberFormatException e) { // Ketika terjadi exception maka akan dijalanakan
            // Output
            System.out.println("Terjadi NumberFormatException: " + e.getMessage());
            System.out.println("Input tidak dapat dikonversi menjadi integer");
            System.out.println("Exception Handler berhasil");
        } catch (Exception e) { // Ketika terjadi exception lain selain NumberFormatException
            System.out.println("Terjadi exception: " + e.getMessage());
        } finally { // Selalu dijalankan tidak peduli terjadi exception atau tidak
            System.out.println("Proses selesai");
        }
    }
}