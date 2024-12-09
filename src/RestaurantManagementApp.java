import java.io.IOException;
import java.util.Scanner;

public class RestaurantManagementApp {

    private static Menu menu = new Menu();
    private static Pesanan pesananSaatIni = new Pesanan();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean keluar = false;

        while (!keluar) {
            tampilkanMenuUtama();
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (pilihan) {
                    case 1:
                        tambahItemMenu();
                        break;
                        case 2:
                            menu.tampilkanMenu();
                            break;
                            case 3:
                                buatPesanan();
                                break;
                                case 4:
                                    pesananSaatIni.hitungTotalBiaya();
                                    System.out.println("Total Biaya Pesanan: " + pesananSaatIni.getTotalBiaya());
                                    break;
                                    case 5:
                                        pesananSaatIni.tampilkanStrukPesanan();
                                        simpanStrukPesanan();
                                        break;
                                        case 6:
                                            simpanMenu();
                                            keluar = true;
                                            System.out.println("Terima kasih telah menggunakan aplikasi");
                                            break;
                                            default:
                                                System.out.println("Pilihan tidak valid!");
                }
            } catch (Exception e) {
                System.out.println("Terjadi Kesalahan: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void tampilkanMenuUtama() {
        System.out.println("\n==== MANAJEMEN RESTORAN ===");
        System.out.println("1. Tambah Item Menu");
        System.out.println("2. Tampilkan Menu");
        System.out.println("3. Buat Pesanan");
        System.out.println("4. Hitung Total Biata");
        System.out.println("5. Tampilkan dan simpan Struk Pesanan");
        System.out.println("6. Keluar");
        System.out.print("Pilih menu (1-6): ");
    }

    private static void tambahItemMenu() {
        System.out.println("\n==== TAMBAH ITEM ===");
        System.out.println("1. Makanan");
        System.out.println("2. Minuman");
        System.out.println("3. Diskon");
        System.out.print("Pilih Jenis Item (1-3): ");
        int jenisItem = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Harga: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Kategori: ");
        String kategori = scanner.nextLine();

        switch (jenisItem) {
            case 1:
                System.out.print("Jenis Makanan: ");
                String jenisMakanan = scanner.nextLine();
                System.out.print("vegetarian? (true/false): ");
                boolean vegetarian = scanner.nextBoolean();

                Makanan makananBaru = new Makanan(nama, harga, kategori, jenisMakanan, vegetarian);
                menu.tambahItem(makananBaru);
                System.out.println("Makanan Berhasil ditambahkan!");
                break;
                case 2:
                    System.out.print("Jenis Minuman: ");
                    String jenisMinuman = scanner.nextLine();
                    System.out.print("Beralkohol? (true/false): ");
                    boolean beralkohol = scanner.nextBoolean();

                    Minuman minumanbaru = new Minuman(nama, harga, kategori, jenisMinuman, beralkohol);
                    menu.tambahItem(minumanbaru);
                    System.out.println("Minuman Berhasil ditambahkan!");
                    break;
                    case 3:
                        System.out.print("Presentase Diskon: ");
                        double presentaseDiskon = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Syarat Diskon: ");
                        String syaratDiskon = scanner.nextLine();

                        Diskon diskonBaru = new Diskon(nama, harga, kategori, presentaseDiskon, syaratDiskon);
                        menu.tambahItem(diskonBaru);
                        System.out.println("Diskon Berhasil ditambahkan!");
                        break;
                        default:
                            System.out.println("Pilihan tidak valid!");

        }
    }

    private static void buatPesanan() throws Menu.ItemTidakDitemukanException {
        pesananSaatIni = new Pesanan();
        boolean selesaiPesanan = false;

        while (!selesaiPesanan) {
            menu.tampilkanMenu();
            System.out.print("Masukkan nama item yang ingin dipesan (atau 'selesai') untuk mengakhiri: ");
            String namaItem = scanner.nextLine();

            if (namaItem.equalsIgnoreCase("selesai")) {
                selesaiPesanan = true;
            } else {
                try {
                    MenuItem itemDipesan = menu.cariItemMenu(namaItem);
                    pesananSaatIni.tambahItem(itemDipesan);
                    System.out.println(itemDipesan.getNama() + "Pesanan Berhasil ditambahkan!");
                } catch (Menu.ItemTidakDitemukanException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private static void simpanStrukPesanan() {
        try {
            String namaFile = "struk_pesanan_" + System.currentTimeMillis() + ".txt";
            pesananSaatIni.simpanStrukFile(namaFile);
            System.out.println("Struk Pesanan Berhasil ditambahkan!");
        } catch (IOException e) {
            System.out.println("gagal menyimpan struk: " + e.getMessage());
        }
    }

    private static void simpanMenu() {
        try {
            String namaFile = "menu_restoran.dat";
            menu.simpanMenuFile(namaFile);
            System.out.println("Menu Berhasil ditambahkan!");
        } catch (IOException e) {
            System.out.println("gagal menyimpan menu: " + e.getMessage());
        }
    }
}
