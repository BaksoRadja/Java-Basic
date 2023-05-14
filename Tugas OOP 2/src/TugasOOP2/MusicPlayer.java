package TugasOOP2;

import java.util.ArrayList;
import java.util.Scanner;


class Lagu {
    int idLagu;
    String judul;
    String penyanyi;
    int totalWaktu;
    int played;

    public Lagu(int idLagu, String judul, String penyanyi, int jam, int menit, int detik) {

        this.idLagu = idLagu;
        this.judul = judul;
        this.penyanyi = penyanyi;
        this.totalWaktu = (jam * 3600) + (menit * 60) + detik;
    }
    
    public int getIdLagu() {
        return idLagu;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenyanyi() {
        return penyanyi;
    }

    public int getTotalWaktu() {
        return totalWaktu;
    }

    public int getPlayed() {
        return played;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenyanyi(String penyanyi) {
        this.penyanyi = penyanyi;
    }

    public void setTotalWaktu(int totalWaktu) {
        this.totalWaktu = totalWaktu;
    }

    public void addPlayed(int played) {
        this.played = played;
    }

    
    public void viewInformasi() {

        System.out.println("\nID Lagu : " + this.idLagu);
        System.out.println("Judul Lagu : " + this.judul);
        System.out.println("Penyanyi Lagu : " + this.penyanyi);
        System.out.println("Total Waktu : " + getTotalWaktu() + " detik");
        System.out.println("Diputar Sebanyak : " + this.played + " kali\n");
    }
    
    public void basicinfo(){
        System.out.println("ID Lagu : " + this.idLagu);
        System.out.println("Judul Lagu : " + this.judul);
        System.out.println("Penyanyi Lagu : " + this.penyanyi);
}
}

public class MusicPlayer {
    public static void main(String[] args) {

        MusicPlayer panggilMusicPlayer = new MusicPlayer();
        Scanner in = new Scanner(System.in);
        ArrayList<Lagu> listLagu = new ArrayList<>();
        Lagu lagu = new Lagu(1, "Payung Terbang", "Kufaku Band", 1, 10, 5);
        listLagu.add(lagu);
        int menu;

        do {

            menu = panggilMusicPlayer.menu(in);
            switch (menu) {
                case 1:
                    panggilMusicPlayer.putarLagu(in, listLagu);
                    break;

                case 2:
                    lagu = panggilMusicPlayer.tambahLagu(in, listLagu);
                    listLagu.add(lagu);
                    break;

                case 3:
                    panggilMusicPlayer.daftarLagu(listLagu);
                    break;

                case 4:
                    System.out.println("Terima Kasih Telah Menggunakan Aplikasi Music Player ini");
                    return;
                default:
                    System.out.println("Input Yang Anda Masukkan Tidak Tersedia !\nPilih Antara 1 - 4 !!!");
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
    
    public int menu(Scanner in) {

        System.out.println("\t\tAplikasi Pemutar Lagu");
        System.out.println("1. Cari dan Putar Lagu");
        System.out.println("2. Tambahkan Lagu Baru");
        System.out.println("3. Daftar Lagu");
        System.out.println("4. Exit");
        int menu = Integer.parseInt(in.nextLine());

        return menu;
    }
    
    public Lagu tambahLagu(Scanner in, ArrayList<Lagu> listLagu) {

        System.out.print("Masukkan Judul Lagu Yang Ingin Di Tambahkan : ");
        String judul = in.nextLine();
        System.out.print("Masukkan Nama Penyanyi Lagu Yang Ingin Di Tambahkan : ");
        String penyanyi = in.nextLine();
        System.out.print("Masukkan Durasi Jam Lagu Yang Ingin Di Tambahkan : ");
        int jam = Integer.parseInt(in.nextLine());
        System.out.print("Masukkan Durasi Menit Lagu Yang Ingin Di Tambahkan : ");
        int menit = Integer.parseInt(in.nextLine());
        System.out.print("Masukkan Durasi Detik Lagu Yang Ingin Di Tambahkan : ");
        int detik = Integer.parseInt(in.nextLine());

        return new Lagu(listLagu.size() + 1, judul, penyanyi, jam, menit, detik);

    }

    public void daftarLagu(ArrayList<Lagu> listLagu) {

        for (Lagu lagu : listLagu) {
            lagu.viewInformasi();
        }
    }
    
    public void putarLagu(Scanner in, ArrayList<Lagu> listLagu){
        boolean isRunning = true;
        System.out.print("Judul Lagu Yang Ingin di Putar : ");
        String cari = in.nextLine();
        for (int i = 0; i < listLagu.size(); i++) {
            if (listLagu.get(i).getJudul().contains(cari)) {
                listLagu.get(i).basicinfo();
                isRunning = false;
            }
        }

        if (isRunning == false) {
            System.out.println("Memainkan Lagu");
            System.err.print("\n\nMasukkan ID Lagu : ");
            int idlagu = Integer.parseInt(in.nextLine());
            for (int i = 0; i < listLagu.size(); i++) {
                if (listLagu.get(i).getIdLagu() == idlagu) {
                    listLagu.get(i).addPlayed(listLagu.get(i).getPlayed() + 1);
                    System.out.println("Lagu : " + listLagu.get(i).getJudul() + " Dinyanyikan oleh : " + listLagu.get(i).getPenyanyi() + " Sedang Diputar");
                }
            }
        } else {
            System.out.println("Lagu Tidak Ditemukan !!!");
            pause(2000);
        }
    }
}
