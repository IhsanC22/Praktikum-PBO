import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Daging {
    // Variabel instance dengan access modifier private
    private int id;
    private String jenis;
    private double harga;

    // Constructor untuk inisialisasi objek Daging
    public Daging(int id, String jenis, double harga) {
        this.id = id;
        this.jenis = jenis;
        this.harga = harga;
    }

    // Getter untuk mendapatkan nilai id
    public int getId() {
        return id;
    }

    // Setter untuk mengubah nilai id
    public void setId(int id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}

public class postes2 {

    private static final List<Daging> daftarDaging = new ArrayList<>();
    private static int idSelanjutnya = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("Selamat datang di Program Gudang penyimpanan Daging Black sampoerna");
            System.out.println("1. Tambah Daging");
            System.out.println("2. Lihat Daftar Daging");
            System.out.println("3. Perbarui Data Daging");
            System.out.println("4. Hapus Data Daging");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahDaging(scanner);
                    break;
                case 2:
                    lihatDaftarDaging(scanner);
                    break;
                case 3:
                    perbaruiDaging(scanner);
                    break;
                case 4:
                    hapusDaging(scanner);
                    break;
                case 5:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 5);
        scanner.close();
    }

    private static void tambahDaging(Scanner scanner) {
        System.out.println("Pilih jenis daging:");
        System.out.println("1. Ayam");
        System.out.println("2. Domba");
        System.out.println("3. Sapi");
        System.out.println("4. Kambing");
        System.out.println("5. Babi");
        System.out.print("Masukkan pilihan anda: ");
        int jenisDaging = scanner.nextInt();
        scanner.nextLine(); 

        String jenis;
        switch (jenisDaging) {
            case 1:
                jenis = "Ayam";
                break;
            case 2:
                jenis = "Domba";
                break;
            case 3:
                jenis = "Sapi";
                break;
            case 4:
                jenis = "Kambing";
                break;
            case 5:
                jenis = "Babi";
                break;
            default:
                System.out.println("Pilihan tidak valid");
                return;
        }

        System.out.print("Masukkan harga daging (dalam Rupiah): ");
        double harga = scanner.nextDouble();
        daftarDaging.add(new Daging(idSelanjutnya++, jenis, harga));
        System.out.println("Daging berhasil ditambahkan");
    }

    private static void lihatDaftarDaging(Scanner scanner) {
        if (daftarDaging.isEmpty()) {
            System.out.println("Tidak ada daging yang tersedia");
        } else {
            System.out.println("Daftar Daging:");
            for (Daging daging : daftarDaging) {
                System.out.println(daging.getId() + ": " + daging.getJenis() + " - Rp " + daging.getHarga());
            }
        }
        System.out.println("0. Kembali ke Menu Utama");
        System.out.print("Menu utama: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); 
        if (pilihan == 0) {
            return;
        }
    }

    private static void perbaruiDaging(Scanner scanner) {
        System.out.print("Masukkan ID daging yang akan diperbarui: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
    
        Daging dagingToUpdate = cariDagingById(id);
        if (dagingToUpdate != null) {
            System.out.println("Pilih jenis daging yang baru:");
            System.out.println("1. Ayam");
            System.out.println("2. Domba");
            System.out.println("3. Sapi");
            System.out.println("4. Kambing");
            System.out.println("5. Babi");
            System.out.print("Masukkan pilihan anda: ");
            int jenisDaging = scanner.nextInt();
            scanner.nextLine(); 
    
            String jenis;
            switch (jenisDaging) {
                case 1:
                    jenis = "Ayam";
                    break;
                case 2:
                    jenis = "Domba";
                    break;
                case 3:
                    jenis = "Sapi";
                    break;
                case 4:
                    jenis = "Kambing";
                    break;
                case 5:
                    jenis = "Babi";
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    return;
            }
    
            System.out.print("Masukkan harga daging baru (dalam Rupiah): ");
            double hargaBaru = scanner.nextDouble();
            scanner.nextLine();
    
            dagingToUpdate.setJenis(jenis);
            dagingToUpdate.setHarga(hargaBaru);
            System.out.println("Daging berhasil diperbarui");
        } else {
            System.out.println("Daging tidak ditemukan");
        }
    }

    private static void hapusDaging(Scanner scanner) {
        System.out.print("Masukkan ID daging yang akan dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Daging dagingToDelete = cariDagingById(id);
        if (dagingToDelete != null) {
            daftarDaging.remove(dagingToDelete);
            System.out.println("Daging berhasil dihapus");
        } else {
            System.out.println("Daging tidak ditemukan");
        }
    }

    private static Daging cariDagingById(int id) {
        for (Daging daging : daftarDaging) {
            if (daging.getId() == id) {
                return daging;
            }
        }
        return null;
    }
}
