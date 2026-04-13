import java.util.Scanner;

public class iniMart {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ===== DEKLARASI VARIABEL =====
        String nama = "-";
        String alamat = "-";
        String noHp = "-";
        boolean isMember = false;
        double diskonBelanja = 0;
        double diskonMember = 0;

        // ===== INPUT STATUS MEMBER =====
        System.out.println("       SELAMAT DATANG DI INIMARET        ");
        System.out.print("Apakah anda memiliki membership? (y/n) : ");
        String pilihanMember = input.nextLine();

        // ===== PERCABANGAN 1: CEK MEMBER =====
        if (pilihanMember.equalsIgnoreCase("y")) {
            isMember = true;
            System.out.println("          INPUT DATA MEMBERSHIP           ");
            System.out.print("Nama      : ");
            nama = input.nextLine();
            System.out.print("Alamat    : ");
            alamat = input.nextLine();
            System.out.print("No. HP    : ");
            noHp = input.nextLine();
        }

        // ===== INPUT DATA BARANG =====
        System.out.println("            INPUT DATA BELANJA            ");
        System.out.print("Nama Barang    : ");
        input.nextLine(); // pembersih buffer
        String namaBarang = input.nextLine();

        System.out.print("Harga Barang   : Rp ");
        double hargaBarang = input.nextDouble();

        System.out.print("Jumlah Dibeli  : ");
        int jumlahDibeli = input.nextInt();

        // PROSES TOTAL SEBELUM DISKON 
        double totalSebelumDiskon = hargaBarang * jumlahDibeli;

        //  PERCABANGAN 2: DISKON BELANJA 
        if (totalSebelumDiskon > 300000) {
            diskonBelanja = 10;
        } else if (totalSebelumDiskon > 100000) {
            diskonBelanja = 5;
        } else {
            diskonBelanja = 0;
        }

        // PERCABANGAN 3: DISKON MEMBER 
        if (isMember) {
            diskonMember = 2;
        }

        //  PROSES HITUNG DISKON & TOTAL
        double totalDiskon = ((diskonBelanja + diskonMember) / 100) * totalSebelumDiskon;
        double totalBayar = totalSebelumDiskon - totalDiskon;

        // OUTPUT STRUK 

        System.out.println("             STRUK PEMBAYARAN            ");
        System.out.println("Nama          : " + nama);
        System.out.println("Alamat        : " + alamat);
        System.out.println("No. HP        : " + noHp);
        System.out.println("Status        : " + (isMember ? "Member" : "Non-Member"));
        System.out.println("------------------------------------------");
        System.out.println("Nama Barang   : " + namaBarang);
        System.out.println("Harga Barang  : Rp " + hargaBarang);
        System.out.println("Jumlah Dibeli : " + jumlahDibeli + " pcs");
        System.out.println("------------------------------------------");
        System.out.println("Total Sebelum Diskon : Rp " + totalSebelumDiskon);
        System.out.println("Diskon Belanja       : " + diskonBelanja + "%");
        System.out.println("Diskon Member        : " + diskonMember + "%");
        System.out.println("Total Diskon         : Rp " + totalDiskon);
        System.out.println("------------------------------------------");
        System.out.println("TOTAL BAYAR          : Rp " + totalBayar);
        System.out.println("      Terima kasih telah berbelanja!      ");
        input.close();
    }
}