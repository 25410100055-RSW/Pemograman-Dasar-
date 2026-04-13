import java.util.Scanner;
public class TokoSmart {
    public static void main(String[] args) {
                    
        Scanner input = new Scanner(System.in);

        //Masukkan Input (deklarasi variabel)
        System.out.println("        APLIKASI PENJUALAN TOKO SMART   ");

        System.out.print("Masukkan Nama Barang   : ");
        String namaBarang = input.nextLine();

        System.out.print("Masukkan Harga Barang  : Rp ");
        int hargaBarang = input.nextInt();

        System.out.print("Masukkan Jumlah Dibeli : ");
        int jumlahDibeli = input.nextInt();

        //proses
        int totalBayar = hargaBarang * jumlahDibeli;

        //masukkan output
        System.out.println();;
        System.out.println("             STRUK PEMBAYARAN           ");
        System.out.println("Nama Barang   : " + namaBarang);
        System.out.println("Harga Barang  : Rp " + hargaBarang);
        System.out.println("Jumlah Dibeli : " + jumlahDibeli + " pcs");
        System.out.println("Total Bayar   : Rp " + totalBayar);
        System.out.println("     Terima kasih telah berbelanja!     ");
        input.close();

    } // ← penutup main
} // ← penutup class
