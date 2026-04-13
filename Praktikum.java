import java.util.ArrayList;
import java.util.Scanner;

public class Praktikum {

    // nilai huruf ke bobot (sesuai Pedoman S1 SI Universitas Dinamika 2025)

    static double konversiNilai(String nilai) {
        switch (nilai.toUpperCase()) {
            case "A":  return 4.0;
            case "B+": return 3.5;
            case "B":  return 3.0;
            case "C+": return 2.5;
            case "C":  return 2.0;
            case "D":  return 1.0;
            case "E":  return 0.0;
            default:   return -1;
        }
    }

    // Tentukan beban SKS maksimal berdasarkan IPS
    // Semester 1 & 2 maksimal 20 SKS 
    // Semester 3+ mengikuti tabel IPS 
    static int tentukanMaksSKS(double ips, int semester) {
        if (semester <= 2) {
            return 20; // Semester 1 & 2 maks 20 SKS sesuai pedoman
        }
        if (ips >= 3.50) return 24;
        else if (ips >= 3.00) return 22;
        else if (ips >= 2.00) return 20;
        else return 18;
    }

    static void tampilkanTabelNilai() {
        System.out.println("   Nilai Akhir  Huruf   Bobot  Keterangan  ");
        System.out.println("   80 - 100       A      4.0   Istimewa    ");
        System.out.println("   75 - 79        B+     3.5   Memuaskan   ");
        System.out.println("   65 - 74        B      3.0   Baik        ");
        System.out.println("   60 - 64        C+     2.5   Sedang      ");
        System.out.println("   55 - 59        C      2.0   Cukup       ");
        System.out.println("   40 - 54        D      1.0   Kurang      ");
        System.out.println("    0 - 39        E      0.0   Gagal       ");

    }

    static void tampilkanTabelIPS() {
        System.out.println("        IPS       Beban Belajar Maks ");
        System.out.println("   >= 3.50              24 SKS       ");
        System.out.println("   3.00 - 3.49          22 SKS       ");
        System.out.println("   2.00 - 2.99          20 SKS       ");
        System.out.println("   < 2.00               18 SKS       ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("  KALKULATOR IPK & BEBAN SKS MAHASISWA");
        System.out.println("  Program Studi : S1 Sistem Informasi");
        System.out.println("  Universitas   : Universitas Dinamika");
        System.out.println("  Pedoman       : Pedoman Akademik S1 SI 2025");

        tampilkanTabelNilai();
        tampilkanTabelIPS();

        boolean ulang = true;

        while (ulang) {
            // Input semester aktif
            int semester = 0;
            while (true) {
                System.out.print("\n  Semester aktif saat ini : ");
                try {
                    semester = Integer.parseInt(sc.nextLine().trim());
                    if (semester < 1) {
                        System.out.println("  [!] Semester tidak valid.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("  [!] Masukkan angka semester.");
                }
            }

            ArrayList<String>  namaMK  = new ArrayList<>();
            ArrayList<Integer> sksMK   = new ArrayList<>();
            ArrayList<String>  nilaiMK = new ArrayList<>();

            System.out.println("\n  Masukkan mata kuliah semester " + semester + ".");
            System.out.println("  (Ketik 'selesai' pada nama MK untuk mengakhiri input nilai)\n");

            int nomor = 1;
            while (true) {
                System.out.println("   Mata Kuliah " + nomor + ":");

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

                // Input nilai huruf
                String nilai = "";
                System.out.println("  Nilai yang valid : A, B+, B, C+, C, D, E");
                while (true) {
                    System.out.print("  Nilai Huruf      : ");
                    nilai = sc.nextLine().trim().toUpperCase();
                    if (konversiNilai(nilai) != -1) break;
                    System.out.println("  [!] Nilai tidak valid. Gunakan: A, B+, B, C+, C, D, E");
                }

                namaMK.add(nama);
                sksMK.add(sks);
                nilaiMK.add(nilai);
                System.out.println("  ✓ '" + nama + "' berhasil ditambahkan.\n");
                nomor++;
            }

            // Hitung IPS
            double totalBobotSKS = 0;
            int totalSKS = 0;
            for (int i = 0; i < namaMK.size(); i++) {
                double bobot = konversiNilai(nilaiMK.get(i));
                totalBobotSKS += bobot * sksMK.get(i);
                totalSKS      += sksMK.get(i);
            }

            double ips    = (totalSKS == 0) ? 0.0 : Math.round((totalBobotSKS / totalSKS) * 100.0) / 100.0;
            int    maksSKS = tentukanMaksSKS(ips, semester);

            // Tampilkan ringkasan
            System.out.println("  RINGKASAN HASIL PERHITUNGAN IPS - SEMESTER " + semester);
            System.out.printf("\n  %-4s %-24s %-5s %-5s %-6s %s%n",
                    "No", "Mata Kuliah", "SKS", "Nilai", "Bobot", "Keterangan");
            System.out.println("  " + "-".repeat(60));

            for (int i = 0; i < namaMK.size(); i++) {
                double bobot = konversiNilai(nilaiMK.get(i));
                String ket   = getKeterangan(nilaiMK.get(i));
                System.out.printf("  %-4d %-24s %-5d %-5s %-6.1f %s%n",
                        i + 1, namaMK.get(i), sksMK.get(i), nilaiMK.get(i), bobot, ket);
            }

            System.out.println("  " + "-".repeat(60));
            System.out.printf("  %-35s %d SKS%n", "Total SKS Ditempuh", totalSKS);
            System.out.printf("  %-35s %.2f%n", "Indeks Prestasi Semester (IPS)", ips);
            System.out.printf("  IPS Semester " + semester + "                        : %.2f%n", ips);
            System.out.printf("  Beban SKS Maks Semester Berikutnya  : %d SKS%n", maksSKS);
            System.out.println("  Predikat                             : " + getPredikat(ips));

            if (semester <= 2) {
                System.out.println("  * Batas 20 SKS berlaku untuk Semester 1 & 2 (Pasal 5 ayat 6a)");
            }


            System.out.print("\n  Hitung ulang? (y/t) : ");
            ulang = sc.nextLine().trim().equalsIgnoreCase("y");
        }

        System.out.println("\n  Terima kasih! Semangat kuliah! Sukses selalu!");
        sc.close();
    }

    static String getKeterangan(String nilai) {
        switch (nilai.toUpperCase()) {
            case "A":  return "Istimewa";
            case "B+": return "Memuaskan";
            case "B":  return "Baik";
            case "C+": return "Sedang";
            case "C":  return "Cukup";
            case "D":  return "Kurang";
            case "E":  return "Gagal";
            default:   return "-";
        }
    }

    static String getPredikat(double ips) {
        if      (ips >= 3.50) return "Dengan Pujian (Cumlaude)";
        else if (ips >= 3.00) return "Sangat Memuaskan";
        else if (ips >= 2.00) return "Memuaskan";
        else                  return "Kurang - Harap Konsultasi Dosen Wali";
    }
}
