package TugasOOP2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();

        Mahasiswa mhs = new Mahasiswa("Joko McGregor", 120122123, "Teknik Sipil", "Jl.Suka Mundur, no.34",
                "04-02-2000");
        Mahasiswa mhs2 = new Mahasiswa("James Gunawan", 120122124, "Teknik Elektro", "Jl.Suka Terbang, no.12",
                "05-12-2000");
        mahasiswaList.add(mhs);
        mahasiswaList.add(mhs2);
        int menu;

        do {
            System.out.println("Tugas OOP 2");
            System.out.println("1. Input Data Mahasiswa Baru");
            System.out.println("2. Cari Data Mahasiswa Menggunakan NIM");
            System.out.println("3. Print Data Seluruh Mahasiswa Terdaftar");
            System.out.println("4. Exit");
            menu = in.nextInt();
            in.nextLine();
            switch (menu) {

                case 1:
                    mhs = inputData(in);
                    mahasiswaList.add(mhs);
                    break;

                case 2:
                    printList(mahasiswaList);
                    cariMahasiswa(in, mahasiswaList);
                    break;

                case 3:
                    printList(mahasiswaList);
                    break;

                case 4:
                    System.out.println("Terima Kasih Telah Menggunakan Aplikasi Ini");
                    break;

                default:
                    System.out.println("Pilihan Yang Anda Pilih Tidak Tersedia, Pilih Antara 1 - 5 !!!");
                    pause(2000);
                    continue;
            }
        } while (menu != 4);
    }

    static void pause(int a) {

        try {
            Thread.sleep(a);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static Mahasiswa inputData(Scanner in) {

        System.out.println("\t\tInput Data Baru");
        System.out.print("Masukkan Nama : ");
        String nama = in.nextLine();
        System.out.print("\nMasukkan NIM : ");
        int nim = in.nextInt();
        in.nextLine();
        System.out.print("\nMasukkan Program Studi : ");
        String prodi = in.nextLine();
        System.out.print("\nMasukkan Alamat : ");
        String alamat = in.nextLine();
        System.out.println("\nMasukkan Tanggal Lahir (dd-mm-yyyy) : ");
        String tgl_lahir = in.nextLine();

        return new Mahasiswa(nama, nim, prodi, alamat, tgl_lahir);
    }

    public static void printList(ArrayList<Mahasiswa> mahasiswaList) {

        System.out.println("\n\t\tList Mahasiswa Terdaftar");
        for (Mahasiswa mahasiswa : mahasiswaList) {
            System.out.println("\nNama : " + mahasiswa.getNama());
            System.out.println("NIM : " + mahasiswa.getNim());
            System.out.println("Program Studi : " + mahasiswa.getProdi());
            System.out.println("Alamat : " + mahasiswa.getAlamat());
            System.out.println("Tanggal Lahir : " + mahasiswa.getTgl_lahir() + "\n");
        }
    }

    public static void cariMahasiswa (Scanner in, ArrayList<Mahasiswa> mahasiswaList){
        
        System.out.println("Masukkan NIM Mahasiswa yang ingin dicari : ");
        int dicari = in.nextInt();
        in.nextLine();
        for (Mahasiswa mahasiswa : mahasiswaList) {
            if (mahasiswa.getNim() == dicari) {
                System.out.println("\nMahasiswa Ditemukan !\nBerikut Data - Data Mahasiswa Tersebut : ");
                System.out.println("\nNama : " + mahasiswa.getNama());
                System.out.println("NIM : " + mahasiswa.getNim());
                System.out.println("Program Studi : " + mahasiswa.getProdi());
                System.out.println("Alamat : " + mahasiswa.getAlamat());
                System.out.println("Tanggal Lahir : " + mahasiswa.getTgl_lahir() + "\n");

                return;
            }
        }
        System.out.println("\nMahasiswa Tidak Ditemukan! Pastikan Memasukkan NIM Yang Benar");
    }

}

class Mahasiswa {
    String nama;
    int nim;
    String prodi;
    String alamat;
    String tgl_lahir;

    public Mahasiswa(String nama, int nim, String prodi, String alamat, String tgl_lahir) {

        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
        this.alamat = alamat;
        this.tgl_lahir = tgl_lahir;
    }

    public String getNama() {
        return this.nama;
    }
    
    public int getNim() {
        return this.nim;
    }
    
    public String getProdi() {
        return this.prodi;
    }
    
    public String getAlamat() {
        return this.alamat;
    }

    public String getTgl_lahir() {
        return this.tgl_lahir;
    }

}