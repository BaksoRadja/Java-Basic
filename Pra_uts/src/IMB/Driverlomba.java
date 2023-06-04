package IMB;

import java.util.ArrayList;
import java.util.Scanner;

public class Driverlomba {

    private void printPeserta(ArrayList<Peserta> seluruhPeserta) {
        for (Peserta peserta : seluruhPeserta) {
            peserta.viewData();
            System.out.print("\n");
        }
    }
    
    private void printKelompok(ArrayList<Lomba> seluruhKelompok) {
        for (Lomba kelompok : seluruhKelompok) {
            kelompok.viewData();
            System.out.print("\n");
        }
    }

    private void main_menu() {
        System.out.println("\t\tIT Telkom Mencari Bakat");
        System.out.println("1. Daftarkan Kelompok");
        System.out.println("2. Input Nilai");
        System.out.println("3. Cari Kelompok");
        System.out.println("4. Lihat Seluruh Kelompok");
        System.out.println("5. Exit");
    }

    private void mendaftar_kelompok(Scanner in, ArrayList<Lomba> seluruhKelompok,
            ArrayList<Peserta> seluruhPeserta, ArrayList<Ui_ux> pesertaUi_ux, ArrayList<Algoritma> pesertaAlgoritma,
            ArrayList<Data_processing> pesertaDataprocessing) {

        System.out.println("\t\tMendaftarkan Kelompok");
        System.out.print("Masukkan Nama Kelompok : ");
        String nama_kelompok = in.nextLine();
        Lomba kelompok = new Lomba(nama_kelompok, seluruhKelompok.size() + 1, 1, 0, 0, 0);
        
        System.out.println("\t\tKategori Lomba");
        System.out.println("1. UI/UX");
        System.out.println("2. Algoritma");
        System.out.println("3. Data Processing");
        System.out.print("Kategori lomba yang akan diikuti : ");
        int kategori = Integer.parseInt(in.nextLine());

        switch (kategori) {
            case 1:
                Ui_ux uiux = new Ui_ux(nama_kelompok, seluruhKelompok.size() + 1, 1, 0, 0, 0, 0);
                pesertaUi_ux.add(uiux);
                break;

            case 2:
                Algoritma algoritma = new Algoritma(nama_kelompok, seluruhKelompok.size() + 1, 2, 0, 0, 0);
                pesertaAlgoritma.add(algoritma);
                break;

            case 3:
                Data_processing dataprocessing = new Data_processing(nama_kelompok, seluruhKelompok.size() + 1, 3, 0, 0,
                        0);
                pesertaDataprocessing.add(dataprocessing);
                break;

            default:
                System.out.println("Pilihan yang anda pilih tidak tersedia, pilih 1 - 3 !!");
                break;

        }
        for (int i = 1; i <= 5; i++) {
            System.out.printf("Masukkan Nama Peserta %d : ", i);
            String nama_peserta = in.nextLine();
            Peserta peserta = new Peserta(nama_kelompok, nama_peserta, seluruhKelompok.size() + 1,
                    seluruhPeserta.size() + 1);
            
            seluruhPeserta.add(peserta);
        }
        seluruhKelompok.add(kelompok);
    }

    public static void main(String[] args) {

        Driverlomba driver = new Driverlomba();
        Scanner in = new Scanner(System.in);
        ArrayList<Peserta> seluruhPeserta = new ArrayList<>();
        ArrayList<Lomba> seluruhKelompok = new ArrayList<>();
        ArrayList<Ui_ux> pesertaUi_ux = new ArrayList<>();
        ArrayList<Algoritma> pesertaAlgoritma = new ArrayList<>();
        ArrayList<Data_processing> pesertaDataprocessing = new ArrayList<>();

        Ui_ux uiux = new Ui_ux("Kontol", 1, 1, 100, 80, 70, 90);
        seluruhKelompok.add(uiux);
        Data_processing dp = new Data_processing("Dapidap", 2, 3, 100, 80, 70);
        seluruhKelompok.add(dp);
        Algoritma algo = new Algoritma("lotnok", 3, 2, 100, 80, 70);
        seluruhKelompok.add(algo);

        int pilihan;
        do {
            
            driver.main_menu();
            pilihan = Integer.parseInt(in.nextLine());
            switch (pilihan) {
    
                case 1:
                    driver.mendaftar_kelompok(in, seluruhKelompok, seluruhPeserta, pesertaUi_ux, pesertaAlgoritma,
                            pesertaDataprocessing);
                    seluruhKelompok.get(0).viewData();
                    seluruhKelompok.get(1).viewData();
                    driver.printPeserta(seluruhPeserta);
                    break;
    
                case 2:
    
                    break;
    
                case 3:
    
                    break;
    
                case 4:
                    driver.printKelompok(seluruhKelompok);
                    break;
    
                case 5:
                    System.out.println("Terima Kasih telah menggunakan aplikasi ini!!");
                    break;
                default:
                    System.out.println("Pilihan Yang Anda Pilih Tidak Tersedia !!");
                    break;
            }
        } while (pilihan != 5);
        // Ui_ux uiux = new Ui_ux("kelompok Kontol", "Kontolia", 0, 0, 100, 90, 90,
        // 100);
        // System.out.println(uiux.getAverage_nilai());
        // uiux.setNilai_a(50);
        // System.out.println(uiux.getAverage_nilai());
        // Data_processing data = new Data_processing("Kelompok Namek", "namekiani", 1,
        // 1, 100, 80, 100);
        // System.out.println(data.getAverage_nilai());
        in.close();
    }
}
