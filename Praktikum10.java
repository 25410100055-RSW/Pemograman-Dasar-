public class Praktikum10 {
    //Soal 1
    static void cetakGaris() {
        for (int i = 0; i <30; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
    //Soal 2
    static void tampilanMahasiswa(String nama, String nim, double  ipk) {
        System.out.println("Nama : " + nama);
        System.out.println("NIM : " + nim);
        System.out.println("IPK : " + ipk);
    }
    //Soal 3
    static void cetakTable(int angka) {
        System.out.println("Perkalian " + angka);
        for (int i = 1; i <= 10; i++) {
            System.out.println(angka + " x " + i + " = " + (angka * i));
        }
    }

//main dari 1 - 3
//SOAL 1
public static void main(String[] args) {
        cetakGaris();
        System.out.println("Praktikum 10");
        cetakGaris();
        System.out.println("Cetak Garis");
        cetakGaris();
        System.out.println("Selesai");
        cetakGaris();
        
    
//SOAL 2
        tampilanMahasiswa("Dimas", "123456789", 3.5);
        cetakGaris();
//SOAL 3
        cetakTable(1);
        System.out.println("");
        cetakTable(2);
        System.out.println("");
        cetakTable(3);
}

}