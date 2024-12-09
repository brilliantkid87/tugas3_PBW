import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Pesanan implements Serializable {

    private ArrayList<MenuItem> itemDipesan;
    private double totalBiaya;
    private Date waktuPesanan;

//    konstruktor
    public Pesanan() {
        itemDipesan = new ArrayList<>();
        totalBiaya = 0;
        waktuPesanan = new Date();
    }

    public void tambahItem(MenuItem item) {
        itemDipesan.add(item);
        totalBiaya += item.getHarga();
    }

    public void hitungTotalBiaya() {
        totalBiaya = 0;
        for (MenuItem item : itemDipesan) {
            if (item instanceof Diskon) {
                Diskon diskon = (Diskon) item;
                totalBiaya += diskon.hitungHargaSetelahDiskon();
            } else {
                totalBiaya += item.getHarga();
            }
        }
    }

    public void tampilkanStrukPesanan() {
        System.out.println("==== STRUK PESANAN ===");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println("Waktu Pesanan: " +sdf.format(waktuPesanan));

        for (MenuItem item : itemDipesan) {
            System.out.println(item.getNama() + " - Rp " + item.getHarga());

        }
        System.out.println("------------------------");
        System.out.println("Total biaya: Rp" + totalBiaya);
    }

    public void simpanStrukFile(String namaFile) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(namaFile))) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            out.println("==== STRUK PESANAN ===");
            out.println("Waktu Pesanan: " +sdf.format(waktuPesanan));

            for (MenuItem item : itemDipesan) {
                out.println(item.getNama() + " - Rp " + item.getHarga());
            }

            out.println("------------------------");
            out.println("Total biaya: Rp" + totalBiaya);
        }
    }

    public ArrayList<MenuItem> getItemDipesan() {
        return itemDipesan;
    }
    public double getTotalBiaya() {
        return totalBiaya;
    }
    public Date getWaktuPesanan() {
        return waktuPesanan;
    }
}
