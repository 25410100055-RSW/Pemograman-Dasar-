import java.util.Scanner;

public class iniMaret {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nama = "-";
        String alamat = "-";
        String noHp = "-";
        boolean member = false;
        double diskon1 = 0;
        double diskon2 = 0;

        System.out.println("selamat datang di inimaret");
        System.out.print("apakah anda member? (y/n) : ");
        String jwb = sc.nextLine();

        if (jwb.equals("y")) {
            member = true;
            System.out.print("nama : ");
            nama = sc.nextLine();
            System.out.print("alamat : ");
            alamat = sc.nextLine();
            System.out.print("no hp : ");
            noHp = sc.nextLine();
        }
System.out.print("jumlah barang (maks 5) : ");
int jmlBarang = sc.nextInt();
while (jmlBarang > 5 || jmlBarang < 1) {
    System.out.println("Kebanyakan barangnya mas ");
    jmlBarang = sc.nextInt();
}
sc.nextLine();
        String[] nmBarang = new String[jmlBarang];
        double[] harga = new double[jmlBarang];
        int[] jml = new int[jmlBarang];
        double[] sub = new double[jmlBarang];

        for (int i = 0; i < jmlBarang; i++) {
            System.out.println("barang ke " + (i+1));
            System.out.print("nama : ");
            nmBarang[i] = sc.nextLine();
            System.out.print("harga : ");
            harga[i] = sc.nextDouble();
            System.out.print("jumlah : ");
            jml[i] = sc.nextInt();
            sc.nextLine();
            sub[i] = harga[i] * jml[i];
        }

        double total = 0;
        for (int i = 0; i < jmlBarang; i++) {
            total = total + sub[i];
        }

        if (total > 3000.000) {
            diskon1 = 10;
        } else if (total > 100000) {
            diskon1 = 5;
        }

        if (member == true) {
            diskon2 = 2;
        }

        double totDiskon = ((diskon1 + diskon2) / 100) * total;
        double bayar = total - totDiskon;

        System.out.println(" struk ");
        System.out.println("nama : " + nama);
        System.out.println("alamat : " + alamat);
        System.out.println("no hp : " + noHp);
        if (member == true) {
            System.out.println("status : member");
        } else {
            System.out.println("status : tidak member");
        }

        System.out.println(" barang ");
        for (int i = 0; i < jmlBarang; i++) {
        System.out.println(nmBarang[i] + " | Rp " + (long)harga[i] + " | " + jml[i] + " | Rp " + (long)sub[i]);
        }

        System.out.println("total sebelum diskon : Rp " + (long)total);
        System.out.println("potongan : Rp " + (long)totDiskon);
        System.out.println("total bayar : Rp " + (long)bayar);

        sc.close();
    }
}