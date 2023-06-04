package IMB;

class Peserta {
    String nama_kelompok;
    String nama_peserta;
    int idKelompok;
    int idPeserta;

    public Peserta(String nama_kelompok, String nama_peserta, int idKelompok, int idPeserta) {
        this.nama_kelompok = nama_kelompok;
        this.nama_peserta = nama_peserta;
        this.idKelompok = idKelompok;
        this.idPeserta = idPeserta;
    }

    public void viewData() {
        System.out.println("Nama : " + nama_peserta);
        System.out.println("ID : " + idPeserta);
    }

}

class Lomba {

    float average_nilai; // Hasil Rata-Rata Nilai
    String nama_kelompok;
    int idKelompok;
    float nilai_a; // Nilai kriteria 1
    float nilai_b; // Nilai kriteria 2
    float nilai_c; // Nilai kriteria 3
    int kategori;

    public Lomba(String nama_kelompok, int idKelompok, int kategori, float nilai_a, float nilai_b, float nilai_c) {
        this.nama_kelompok = nama_kelompok;
        this.idKelompok = idKelompok;
        this.kategori = kategori;
        this.nilai_a = nilai_a;
        this.nilai_b = nilai_b;
        this.nilai_c = nilai_c;
    }

    public void viewData() {
        System.out.println("Nama Kelompok : " + nama_kelompok);
        System.out.println("Id Kelompok : " + idKelompok);
        switch (kategori) {
            case 1:
                System.out.println("Kategori lomba yang diikuti : UI/UX");
                break;

            case 2:
                System.out.println("Kategori lomba yang diikuti : Algoritma");
                break;

            case 3:
                System.out.println("Kategori lomba yang diikuti : Data Processing");
                break;
            default:
                break;
        }
    }

    public float getAverage_nilai() {
        average_nilai = ((nilai_a + nilai_b + nilai_c) / 3);
        return average_nilai;
    }

    public void setNilai_a(float nilai_a) {
        this.nilai_a = nilai_a;
    }

    public void setNilai_b(float nilai_b) {
        this.nilai_b = nilai_b;
    }

    public void setNilai_c(float nilai_c) {
        this.nilai_c = nilai_c;
    }
}

class Ui_ux extends Lomba {

    float nilai_d; // Nilai kriteria 4

    public Ui_ux(String nama_kelompok, int idKelompok, int kategori, float nilai_a, float nilai_b, float nilai_c,
            float nilai_d) {
        super(nama_kelompok, idKelompok, kategori, nilai_a, nilai_b, nilai_c);
        this.nilai_d = nilai_d;
    }

    public void setNilai_d(float nilai_d) {
        this.nilai_d = nilai_d;
    }

    @Override
    public float getAverage_nilai() {
        average_nilai = ((nilai_a + nilai_b + nilai_c + nilai_d) / 4);
        return average_nilai;
    }
}

class Algoritma extends Lomba {
    public Algoritma(String nama_kelompok, int idKelompok, int kategori, float nilai_a, float nilai_b, float nilai_c) {
        super(nama_kelompok, idKelompok, kategori, nilai_a, nilai_b, nilai_c);
    }
}

class Data_processing extends Lomba {
    public Data_processing(String nama_kelompok, int idKelompok, int kategori, float nilai_a, float nilai_b,
            float nilai_c) {
        super(nama_kelompok, idKelompok, kategori, nilai_a, nilai_b, nilai_c);
    }
}
