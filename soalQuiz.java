import java.util.Scanner;

public class soalQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int komplain;
        int totalMinggu;
        int totalKeseluruhan = 0;
        int mingguKe = 1;

        System.out.println("Pencatatan Komplain Pelanggan");

        while (true) {                                          // loop luar
            totalMinggu = 0;
            System.out.println("\nMinggu ke-" + mingguKe + ":");
            System.out.print("Input: ");

            komplain = scanner.nextInt();

            while (komplain != 0) {                            // loop dalam
                totalMinggu += komplain;
                komplain = scanner.nextInt();
            }

            System.out.println("Total: " + totalMinggu);
            totalKeseluruhan += totalMinggu;

            System.out.println("Lanjut? (ya/tidak)");
            String lanjut = scanner.next();

            if (lanjut.equalsIgnoreCase("tidak")) break;       // stop loop

            mingguKe++;
        }

        System.out.println("\nLaporan Akhir");
        System.out.println("Minggu  : " + mingguKe);
        System.out.println("Komplain: " + totalKeseluruhan);

        scanner.close();
    }
}