import java.util.ArrayList;
import java.util.Scanner;
public class Praktikum {

    // Konversi nilai huruf ke bobot
    static double konversiNilai(String nilai) {
        switch (nilai.toUpperCase()) {
            case "A":  return 4.00;
            case "AB": return 3.50;
            case "B":  return 3.00;
            case "BC": return 2.50;
            case "C":  return 2.00;
            case "D":  return 1.00;
            case "E":  return 0.00;
            default:   return -1;
        }
    }

    // Tentukan beban SKS maksimal berdasarkan IPS
    static int tentukanMaksSKS(double ips) {
        if (ips >= 3.50) return 24;
        else if (ips >= 3.00) return 22;
        else if (ips >= 2.00) return 20;
        else return 18;
    }

    // Tampilkan tabel konversi nilai
    static void tampilkanTabelNilai() {
        System.out.println("\n  +--------+-------+");
        System.out.println("  | Nilai  | Bobot |");
        System.out.println("  +--------+-------+");
        System.out.println("  | A      | 4.00  |");
        System.out.println("  | AB     | 3.50  |");
        System.out.println("  | B      | 3.00  |");
        System.out.println("  | BC     | 2.50  |");
        System.out.println("  | C      | 2.00  |");
        System.out.println("  | D      | 1.00  |");
        System.out.println("  | E      | 0.00  |");
        System.out.println("  +--------+-------+");
    }

    // Tampilkan tabel aturan SKS
    static void tampilkanTabelIPS() {
        System.out.println("\n  +---------------+------------------+");
        System.out.println("  |      IPS      | Maks SKS Semester|");
        System.out.println("  +---------------+------------------+");
        System.out.println("  | >= 3.50       |        24        |");
        System.out.println("  | 3.00 - 3.49   |        22        |");
        System.out.println("  | 2.00 - 2.99   |        20        |");
        System.out.println("  | < 2.00        |        18        |");
        System.out.println("  +---------------+------------------+");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n============================================================");
        System.out.println("  KALKULATOR IPS & BEBAN SKS MAHASISWA");
        System.out.println("  Program Studi : Sistem Informasi");
        System.out.println("  Semester      : 2 (Dua)");
        System.out.println("============================================================");

        tampilkanTabelNilai();
        tampilkanTabelIPS();

        boolean ulang = true;

        while (ulang) {
            ArrayList<String> namaMK   = new ArrayList<>();
            ArrayList<Integer> sksMK  = new ArrayList<>();
            ArrayList<String> nilaiMK = new ArrayList<>();

            System.out.println("\n  Masukkan mata kuliah yang ditempuh semester ini.");
            System.out.println("  (Ketik 'selesai' pada nama MK untuk mengakhiri input)\n");

            int nomor = 1;
            while (true) {
                System.out.println("  --- Mata Kuliah #" + nomor + " ---");

                // Input nama MK
                System.out.print("  Nama Mata Kuliah : ");
                String nama = sc.nextLine().trim();
                if (nama.equalsIgnoreCase("selesai")) {
                    if (nomor == 1) {
                        System.out.println("  [!] Minimal masukkan 1 mata kuliah.");
                        continue;
                    }
                    break;
                }

                // Input SKS
                int sks = 0;
                while (true) {
                    System.out.print("  Jumlah SKS       : ");
                    try {
                        sks = Integer.parseInt(sc.nextLine().trim());
                        if (sks <= 0) {
                            System.out.println("  [!] SKS harus lebih dari 0.");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("  [!] Masukkan angka untuk SKS.");
                    }
                }

                // Input nilai
                String nilai = "";
                System.out.println("  Nilai yang valid : A, AB, B, BC, C, D, E");
                while (true) {
                    System.out.print("  Nilai Huruf      : ");
                    nilai = sc.nextLine().trim().toUpperCase();
                    if (konversiNilai(nilai) != -1) break;
                    System.out.println("  [!] Nilai tidak valid. Gunakan: A, AB, B, BC, C, D, E");
                }

                namaMK.add(nama);
                sksMK.add(sks);
                nilaiMK.add(nilai);
                System.out.println("  Mata kuliah '" + nama + "' berhasil ditambahkan.\n");
                nomor++;
            }

            // Hitung IPS
            double totalBobotSKS = 0;
            int totalSKS = 0;
            for (int i = 0; i < namaMK.size(); i++) {
                double bobot = konversiNilai(nilaiMK.get(i));
                totalBobotSKS += bobot * sksMK.get(i);
                totalSKS += sksMK.get(i);
            }

            double ips = (totalSKS == 0) ? 0.0 : Math.round((totalBobotSKS / totalSKS) * 100.0) / 100.0;
            int maksSKS = tentukanMaksSKS(ips);

            // Tampilkan ringkasan
            System.out.println("\n============================================================");
            System.out.println("  RINGKASAN HASIL PERHITUNGAN IPS");
            System.out.println("============================================================");
            System.out.printf("\n  %-4s %-25s %-5s %-6s %s%n", "No", "Mata Kuliah", "SKS", "Nilai", "Bobot");
            System.out.println("  " + "-".repeat(52));

            for (int i = 0; i < namaMK.size(); i++) {
                double bobot = konversiNilai(nilaiMK.get(i));
                System.out.printf("  %-4d %-25s %-5d %-6s %.2f%n",
                        i + 1, namaMK.get(i), sksMK.get(i), nilaiMK.get(i), bobot);
            }

            System.out.println("  " + "-".repeat(52));
            System.out.printf("  %-35s %d SKS%n", "Total SKS Ditempuh", totalSKS);
            System.out.printf("  %-35s %.2f%n", "Indeks Prestasi Semester (IPS)", ips);
            System.out.println("============================================================");

            System.out.printf("  IPS Anda                             : %.2f%n", ips);
            System.out.printf("  Beban SKS Maksimal Semester Depan   : %d SKS%n", maksSKS);

            String predikat;
            if      (ips >= 3.50) predikat = "Sangat Memuaskan";
            else if (ips >= 3.00) predikat = "Memuaskan";
            else if (ips >= 2.00) predikat = "Cukup";
            else                  predikat = "Kurang - Perlu Bimbingan Akademik";

            System.out.println("  Predikat                             : " + predikat);
            System.out.println("============================================================");

            // Tanya ulang
            System.out.print("\n  Apakah ingin menghitung ulang? (y/t) : ");
            String jawab = sc.nextLine().trim().toLowerCase();
            ulang = jawab.equals("y");
        }

        System.out.println("\n  Terima kasih! Semangat kuliah semester 2!");
        System.out.println("============================================================\n");
        sc.close();
    }
}