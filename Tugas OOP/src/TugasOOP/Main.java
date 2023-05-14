package TugasOOP;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        
        Calculator panggilCalculator = new Calculator();
        Main panggilMain = new Main();

        while (true) {

            // UI Menu Utama
            System.out.println("======================================================");
            System.out.println("=\t\tTugas Ngabuburit\t\t     =");
            System.out.println("======================================================");
            System.out.println("= 1.Hitung Faktorial                                 =");
            System.out.println("= 2.Hitung Waktu Pertemuan Antara 2 Benda Bergerak   =");
            System.out.println("= 3.Cek Bilangan Prima                               =");
            System.out.println("= 4.Daftar Bilangan Prima                            =");
            System.out.println("= 5.Deret Fibonacci                                  =");
            System.out.println("= 6.Exit                                             =");
            System.out.println("======================================================");
            System.out.print("Input Anda : ");

            int menu = input.nextByte();

            switch (menu) {

                case 1:
                    panggilCalculator.faktorial();
                    break;

                case 2:
                    panggilCalculator.waktu_temu();
                    break;

                case 3:
                    panggilCalculator.cek_prima();
                    break;

                case 4:
                    panggilCalculator.daftar_prima();
                    break;

                case 5:
                    panggilCalculator.fibonacci();
                    break;

                case 6:
                    System.out.println("Terima Kasih Telah Menggunakan Aplikasi Ini :)");
                    return;

                default:
                    System.out.println("Pilihan yang Anda Pilih Tidak Tersedia, Pilih Antara 1-6 !!");
                    panggilMain.pause(2000);
                    continue;
            }
            panggilMain.pause(2000);
            System.out.print("\nIngin Mengulang ? (y/n)  ");
            char yn = input.next().charAt(0);
            if (yn == 'n') {
                return;
            }
        }
    }

    void pause(int a) {

        try {
            Thread.sleep(a);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}