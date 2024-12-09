public class Minuman extends  MenuItem{
    private String jenisMinuman;
    private boolean beralkohol;

    public Minuman(String nama, double harga, String kategori, String jenisMinuman, boolean beralkohol) {
        super(nama, harga, kategori);
        this.jenisMinuman = jenisMinuman;
        this.beralkohol = beralkohol;
    }

    public void tampilMenu() {
        System.out.println("Minuman: " + nama);
        System.out.println("Harga: " + harga);
        System.out.println("Kategori: " + kategori);
        System.out.println("Jenis Minuman: " + jenisMinuman);
        System.out.println("Beralkohol: " + beralkohol);
    }

    public String getJenisMinuman() {
        return jenisMinuman;
    }
    public void setJenisMinuman(String jenisMinuman) {
        this.jenisMinuman = jenisMinuman;
    }

    public boolean isBeralkohol() {
        return beralkohol;
    }
    public void setBeralkohol(boolean beralkohol) {
        this.beralkohol = beralkohol;
    }
}
