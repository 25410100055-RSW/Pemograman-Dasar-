import java.util.Scanner;

public class LatihanArray1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] kategori = null;
        int[] harga = null;
        int[] jumlahBeli = null;
        int total = 0, pilihMenu = 0, jmlKategori = 0;

        do {
            System.out.println("\nPemesanan Tiket Surabaya Zoo");
            System.out.println("1. Input Kategori Tiket");
            System.out.println("2. Input Jumlah Beli");
            System.out.println("3. Lihat Total Bayar");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu : ");
            pilihMenu = sc.nextInt();

            switch (pilihMenu) {
                case 1:
                    System.out.print("Masukkan Jumlah Kategori Tiket : ");
                    jmlKategori = sc.nextInt();
                    sc.nextLine();
                    kategori = new String[jmlKategori];
                    harga = new int[jmlKategori];
                    jumlahBeli = new int[jmlKategori];

                    for (int i = 0; i < jmlKategori; i++) {
                        System.out.print("Masukkan Nama Kategori Tiket ke-" + (i + 1) + " : ");
                        kategori[i] = sc.nextLine();
                        System.out.print("Masukkan Harga Kategori Tiket ke-" + (i + 1) + " : ");
                        harga[i] = sc.nextInt();
                        sc.nextLine();
                    }

                    System.out.println("\nData kategori berhasil disimpan!");
                    for (int i = 0; i < jmlKategori; i++) {
                        System.out.println("Kategori Tiket ke-" + (i + 1) + " : " + kategori[i]);
                        System.out.println("Harga Tiket ke-" + (i + 1) + " : " + harga[i]);
                    }
                    break;

                case 2:
                    if (kategori == null) {
                        System.out.println("Harap isi menu 1 terlebih dahulu!");
                        break;
                    }
                    for (int i = 0; i < jmlKategori; i++) {
                        System.out.print("Masukkan Jumlah Beli Tiket " + kategori[i] + " : ");
                        jumlahBeli[i] = sc.nextInt();
                    }
                    System.out.println("Jumlah beli berhasil disimpan!");
                    break;

                case 3:
                    if (kategori == null || jumlahBeli == null) {
                        System.out.println("Harap isi menu 1 dan 2 terlebih dahulu!");
                        break;
                    }
                    total = 0;
                    System.out.println("\nRincian Pembelian Tiket:");
                    for (int i = 0; i < jmlKategori; i++) {
                        int subtotal = harga[i] * jumlahBeli[i];
                        total += subtotal;
                        System.out.println(kategori[i] + " x" + jumlahBeli[i] + " = Rp " + subtotal);
                    }
                    System.out.println("Total Bayar : Rp " + total);
                    break;

                case 4:
                    System.out.println("Terima kasih! Sampai jumpa di Surabaya Zoo!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihMenu != 4);

        sc.close();
    }
}
