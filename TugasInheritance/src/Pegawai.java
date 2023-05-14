class Pegawai {
    protected String nama;
    protected double gaji;

    public Pegawai(String nama, double gaji) {
        this.nama = nama;
        this.gaji = gaji;
    }

    public String getNama() {
        return nama;
    }

    public double getGaji() {
        return gaji;
    }

}

class PegawaiKontrak extends Pegawai {
    protected double lembur;

    public PegawaiKontrak(String nama, double gaji) {
        super(nama, gaji);
    }

    public void setLembur(double lembur) {
        this.lembur = lembur;
    }

    public double getGaji() {
        return gaji + lembur;
    }

}

class PegawaiTetap extends Pegawai {
    protected double tunjangan;
    protected double bonus;

    public PegawaiTetap(String nama, double gaji) {
        super(nama, gaji);
    }

    public void setTunjangan(double tunjangan) {
        this.tunjangan = tunjangan;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getGaji() {
        return gaji + tunjangan + bonus;
    }

}

class DriverPegawai {
    public static void main(String[] args) {
        Pegawai pg = new Pegawai("Joko McGreggor", 5000000);
        System.out.println("Nama Pegawai : " + pg.getNama());
        System.out.println("Gaji Total Pegawai : Rp." + pg.getGaji());

        PegawaiKontrak pk = new PegawaiKontrak("Rahmadi Setiawan", 13000000);
        pk.setLembur(4000000);
        System.out.println("Nama Pegawai : " + pk.getNama());
        System.out.println("Gaji Total Pegawai : RP." + pk.getGaji());

        PegawaiTetap pt = new PegawaiTetap("Biggus Dickus", 100000000);
        pt.setBonus(50000000);
        pt.setTunjangan(6000000);
        System.out.println("Nama Pegawai : " + pt.getNama());
        System.out.println("Gaji Total Pegawai : RP." + pt.getGaji());
    }
}
