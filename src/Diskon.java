public class Diskon extends MenuItem{

    private double persentaseDiskon;
    private String syaratDiskon;

    public Diskon(String nama, double harga, String Kategori, double persentaseDiskon, String syaratDiskon){
        super(nama, harga, Kategori);
        this.persentaseDiskon = persentaseDiskon;
        this.syaratDiskon = syaratDiskon;
    }
    @Override
    public void tampilMenu() {
        System.out.println("Diskon: " + nama);
        System.out.println("Harga Asli: " + harga);
        System.out.println("Harga Setelah Diskon: " + hitungHargaSetelahDiskon());
        System.out.println("Prsentase Diskon: " + persentaseDiskon);
        System.out.println("Syarat Diskon: " + syaratDiskon);
    }

    public double hitungHargaSetelahDiskon() {
        return harga * persentaseDiskon / 100;
    }

    public double getPersentaseDiskon() {
        return persentaseDiskon;
    }
    public void setPersentaseDiskon(double persentaseDiskon) {
        this.persentaseDiskon = persentaseDiskon;
    }

    public String getSyaratDiskon() {
        return syaratDiskon;
    }
    public void setSyaratDiskon(String syaratDiskon) {
        this.syaratDiskon = syaratDiskon;
    }
}
