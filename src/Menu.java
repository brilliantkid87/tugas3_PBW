import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Menu implements Serializable {
    private ArrayList<MenuItem> daftarMenu;

    public Menu() {
        daftarMenu = new ArrayList<>();
    }

    public void tambahItem(MenuItem item) {
        daftarMenu.add(item);
    }

    public void tampilkanMenu() {
        if (daftarMenu.isEmpty()) {
            System.out.println("Menu tidak ditemukan");
            return;
        }

        System.out.println("=== Daftar Menu ===");
        for (MenuItem item : daftarMenu) {
            item.tampilMenu();
            System.out.println("--------------------------");
        }
    }

    public MenuItem cariItemMenu(String nama) throws ItemTidakDitemukanException {
        for (MenuItem item : daftarMenu) {
            if (item.getNama().equalsIgnoreCase(nama)) {
                return item;
            }
        }
        throw new ItemTidakDitemukanException("Item menu dengan nama " + nama + " tidak ditemukan");
    }

//    metode menyimpan menu file
    public void simpanMenuFile(String namaFile) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(namaFile))) {
            out.writeObject(daftarMenu);
        }
    }

//    method memuat menu file
    @SuppressWarnings("unchecked")
    public void muatMenuDaftarDariFIle(String namaFile) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in  = new ObjectInputStream(new FileInputStream(namaFile))) {
            daftarMenu = (ArrayList<MenuItem>) in.readObject();
        }
    }

//    custom exception
    public static class ItemTidakDitemukanException extends Exception {
        public ItemTidakDitemukanException(String message) {
            super(message);
        }
    }

    public ArrayList<MenuItem> getDaftarMenu() {
        return daftarMenu;
    }
}
