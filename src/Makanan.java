public class Makanan extends MenuItem{
    private String jenisMakanan;
    private boolean vegetarian;

//    konstruktor
    public Makanan(String nama, double harga, String kategori, String jenisMakanan, boolean vegetarian) {
        super(nama, harga, kategori);
        this.jenisMakanan = jenisMakanan;
        this.vegetarian = vegetarian;
    }

//    implementasi polymorphhic method
    @Override
    public void tampilMenu() {
        System.out.println("Makanan: " + nama);
        System.out.println("Harga: " + harga);
        System.out.println("Kategori: " + kategori);
        System.out.println("Jenis Makanan: " + jenisMakanan);
        System.out.println("Vegetarian: " + vegetarian);
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }
    public void setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan = jenisMakanan;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }
    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
}
