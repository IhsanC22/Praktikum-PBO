import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Daging {
    private int id;
    private String jenis;
    private double harga;

    public Daging(int id, String jenis, double harga) {
        this.id = id;
        this.jenis = jenis;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

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

class DagingOlahan extends Daging {
    private String metodePengolahan;

    public DagingOlahan(int id, String jenis, double harga, String metodePengolahan) {
        super(id, jenis, harga);
        this.metodePengolahan = metodePengolahan;
    }

    public String getMetodePengolahan() {
        return metodePengolahan;
    }

    public void setMetodePengolahan(String metodePengolahan) {
        this.metodePengolahan = metodePengolahan;
    }
}

class DagingSegar extends Daging {
    private int tingkatKesegaran;

    public DagingSegar(int id, String jenis, double harga, int tingkatKesegaran) {
        super(id, jenis, harga);
        this.tingkatKesegaran = tingkatKesegaran;
    }

    public int getTingkatKesegaran() {
        return tingkatKesegaran;
    }

    public void setTingkatKesegaran(int tingkatKesegaran) {
        this.tingkatKesegaran = tingkatKesegaran;
    }
}

public class postes3 {
    private static final List<Daging> inventarisDaging = new ArrayList<>();
    private static int idSelanjutnya = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("Selamat datang di Program Gudang Penyimpanan Daging");
            System.out.println("1. Tambah Daging");
            System.out.println("2. Lihat Inventaris Daging");
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
                    lihatInventarisDaging();
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
        System.out.println("1. Daging Olahan");
        System.out.println("2. Daging Segar");
        System.out.print("Masukkan pilihan anda: ");
        int jenisDaging = scanner.nextInt();
        scanner.nextLine(); 

        String jenis;
        double harga;
        String metodePengolahan;
        int tingkatKesegaran;

        System.out.print("Masukkan nama daging: ");
        jenis = scanner.nextLine();
        System.out.print("Masukkan harga daging (dalam Rupiah): ");
        harga = scanner.nextDouble();
        scanner.nextLine();

        switch (jenisDaging) {
            case 1:
                System.out.print("Masukkan metode pengolahan: ");
                metodePengolahan = scanner.nextLine();
                inventarisDaging.add(new DagingOlahan(idSelanjutnya++, jenis, harga, metodePengolahan));
                System.out.println("Daging olahan berhasil ditambahkan");
                break;
            case 2:
                System.out.print("Masukkan tingkat kesegaran: ");
                tingkatKesegaran = scanner.nextInt();
                inventarisDaging.add(new DagingSegar(idSelanjutnya++, jenis, harga, tingkatKesegaran));
                System.out.println("Daging segar berhasil ditambahkan");
                break;
            default:
                System.out.println("Pilihan tidak valid");
        }
    }

    private static void lihatInventarisDaging() {
        if (inventarisDaging.isEmpty()) {
            System.out.println("Tidak ada daging yang tersedia");
        } else {
            System.out.println("Inventaris Daging:");
            for (Daging daging : inventarisDaging) {
                System.out.print(daging.getId() + ": " + daging.getJenis() + " - Rp " + daging.getHarga());
                if (daging instanceof DagingOlahan) {
                    DagingOlahan dagingOlahan = (DagingOlahan) daging;
                    System.out.println(", Metode Pengolahan: " + dagingOlahan.getMetodePengolahan());
                } else if (daging instanceof DagingSegar) {
                    DagingSegar dagingSegar = (DagingSegar) daging;
                    System.out.println(", Tingkat Kesegaran: " + dagingSegar.getTingkatKesegaran());
                }
            }
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
            inventarisDaging.remove(dagingToDelete); // Menggunakan variabel inventarisDaging
            System.out.println("Daging berhasil dihapus");
        } else {
            System.out.println("Daging tidak ditemukan");
        }
    }

    private static Daging cariDagingById(int id) {
        for (Daging daging : inventarisDaging) {
            if (daging.getId() == id) {
                return daging;
            }
        }
        return null;
    }
}
