package TugasOOP;

import java.util.Scanner;

public class Calculator {

    private static Scanner input = new Scanner(System.in);

    public void faktorial() {

        System.out.print("\nMasukkan Bilangan Yang Ingin Dihitung : ");
        long a = input.nextInt();

        //cek apakah a = negatif jika iya hasilnya tidak terdefinisi
        if (a < 0) {
            System.out.println("Hasil : TIDAK TERDEFINISI");
            return;
        }

        System.out.print("\n" + a + "*");
        for (long i = a - 1; i >= 1; i--) {
            System.out.print(i + "*");
            a *= i;
        }
        System.out.println("\nHasil Faktorial : " + a);        
    }
    
    static void cek_prima() {

        System.out.print("\nMasukkan Bilangan Yang Ingin Dicek : ");
        int a = input.nextInt();

        //Jika Input adalah bilangan yang kurang dari 1 maka akan mengeluarkan notif
        if (a < 1) {
            System.out.println("\nBilangan negatif dan 0 tidak termasuk Bilangan Prima karena: \nAngka Negatif bukan merupakan bilangan asli \ndan Angka 0 memiliki faktor tak terhingga \nserta bukan berupa bilangan asli\n\n");
        }

        //Memastikan Apakah a Adalah Bilangan Prima Dengan Mencari Faktor dari Bilangan a
        int faktor = 0;
        for (int i = 1; i <= a; i++) {
            if ((a % i) == 0) {
                faktor++;
            }
        }       
        //Jika Jumlah Faktor Bilangan a adalah 2 maka Bilangan a MERUPAKAN Bilangan Prima Selain itu, maka Bilangan a BUKAN Bilangan Prima 
        if (faktor == 2) {
            System.out.println(a + " MERUPAKAN Bilangan Prima");
        } else {
            System.out.println(a + " BUKAN Bilangan Prima");
        }
    }
    
    static void daftar_prima() {

        System.out.print("\nBatas Untuk Daftar Bilangan Prima : ");
        int a = input.nextInt();

        //cek input agar tidak ada bilangan negatif
        if (a < 1) {
            System.out.println("Masukkan Bilangan Positif (Lebih Dari 0)");
            return;
        }

        System.out.println("Daftar Bilangan Prima 1 - " + a);
        for (int i = 2; i <= a; i++) {

            int faktor = 0;
            //Memastikan apakah bilangan i adalah prima dengan mencari faktor menggunakan modulus
            for (int j = 1; j <= i; j++) {

                if ((i % j) == 0) {
                    faktor++;
                }
            }
            //jika jumlah faktor dari bilangan i = 2 maka bilangan i adalah bilangan prima dan akan di print
            if (faktor == 2) {
                System.out.print(i + ", ");
            }
        }
    }

    static void waktu_temu() {

        while (true) {

            //Input Data2 Yang diperlukan Untuk menghitung hasil
            System.out.print("\nMasukkan Jarak Antara Sepasang Kekasih (Km) : ");
            float jarak = input.nextInt();
            System.out.print("\nMasukkan Kecepatan A (Km/h) : ");
            float kec_a = input.nextInt();
            System.out.print("\nMasukkan Kecepatan B (Km/h) : ");
            float kec_b = input.nextInt();

            //cek input agar tidak ada bilangan negatif
            if (jarak < 0 || kec_a < 0 || kec_b < 0) {
                System.out.println("Salah Satu atau lebih dari Input Adalah Bilangan Negatif, Masukkan Bilangan Positif !!");
                continue;
            }

            //Menghitung Waktu Bertemunya kedua kekasih menggunakan rumus
            //wp = waktu bertemunya kedua kekasih (Hasil akhirnya dalam bentuk menit), kec_a = kecepatan si a, kec_b = Kecepatan si b, jarak = jarak antara si a dan b
            float wp = (jarak / (kec_a + kec_b)) * 60;

            //Mensimulasikan pergerakan sepasang kekasih per menitnya menggunakan looping for
            System.out.println("Pergerakan sepasang kekasih per menintya : ");
            for (int i = 1; i <= wp; i++) {
                float kma = (kec_a / 60) * i;
                float kmb = (kec_b / 60) * i;
                System.out.printf("Menit ke - %d : A berada di Kilometer %.1f, B berada di Kilometer %.1f.\n", i, kma, kmb);
            }
            
            //Print Hasil dari perhitungan
            System.out.printf(
                    "\nJadi waktu pertemuan antara sepasang kekasih yang terpisah sejauh %.1f km, adalah : %.1f Menit\n",
                    jarak, wp);
            break;
        }

    }
    
    static void fibonacci() {

        //input panjang deret fibonacci
        System.out.print("\npanjang Deret Fibonacci : ");
        int panjang = input.nextInt();

        //cek input panjang agar tidak bilangan negatif
        if (panjang < 3) {

            System.out.println("Minimal Panjang Deret Fibonacci adalah 3 Suku bilangan !");
            return;
        }

        //input 2 nilai awal
        System.out.print("\nSuku ke - 1 : ");
        int u1 = input.nextInt();
        System.out.print("Suku ke - 2 : ");
        int u2 = input.nextInt();

        //hitung suku ke - n
        for (int i = 3; i <= panjang; i++) {
            int un = u1 + u2;
            System.out.printf("Suku ke - %d : %d \n", i, un);
            u1 = u2;
            u2 = un;
        }
    }

}