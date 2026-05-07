import java.util.Scanner;

public class Uts{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input mahasiswa
        System.out.print("Masukkan jumlah mahasiswa: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        // array 1 dimensi
        String[] nama = new String[n];
        double[] lamaBelajar = new double[n];

        // data mahasiswa
        for (int i = 0; i < n; i++) {
            System.out.println("\nMahasiswa ke-" + (i + 1));
            System.out.print("Nama mahasiswa: ");
            nama[i] = sc.nextLine().trim();
            System.out.print("Lama belajar per hari (jam): ");
            lamaBelajar[i] = Double.parseDouble(sc.nextLine().trim());
        }

        // rata-rata waktu belajar
        double total = 0;
        for (int i = 0; i < n; i++) {
            total += lamaBelajar[i];
        }
        double rataRata = total / n;

        // Tampilkan rata-rata
        System.out.printf("\nRata-rata waktu belajar: %.2f jam/hari%n", rataRata);

        // Evaluasi tiap mahasiswa
        System.out.println("\n--- Hasil Evaluasi ---");
        for (int i = 0; i < n; i++) {
            System.out.println("\nNama         : " + nama[i]);
            System.out.printf("Lama Belajar : %.1f jam/hari%n", lamaBelajar[i]);
            if (lamaBelajar[i] >= 2 && lamaBelajar[i] <= 4) {
                System.out.println("Status       : AKTIF");
            } else {
                System.out.println("Status       : PERLU MOTIVASI");
            }
        }

        sc.close();
    }
}