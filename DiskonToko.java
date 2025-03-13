import java.util.Scanner;

public class DiskonToko {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan total belanja: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Error: Input harus berupa angka.");
            return;
        }
        double totalBelanja = scanner.nextDouble();
        
        if (totalBelanja < 0) {
            System.out.println("Error: Total belanja tidak bisa negatif.");
            return;
        }
        
        System.out.print("Masukkan tipe member (Platinum/Gold/Silver/None): ");
        String member = scanner.next().trim();
        
        double diskonUtama;
        if (totalBelanja > 500000) {
            diskonUtama = 0.20;
        } else if (totalBelanja >= 250000) {
            diskonUtama = 0.10;
        } else {
            diskonUtama = 0.0;
        }
        
        double totalSetelahDiskon = totalBelanja - (totalBelanja * diskonUtama);
        
        double diskonTambahan;
        switch (member.toLowerCase()) {
            case "platinum":
                diskonTambahan = 0.05;
                break;
            case "gold":
                diskonTambahan = 0.03;
                break;
            case "silver":
                diskonTambahan = 0.02;
                break;
            case "none":
                diskonTambahan = 0.0;
                break;
            default:
                System.out.println("Error: Tipe member tidak valid.");
                return;
        }
        
        double totalAkhir = totalSetelahDiskon - (totalSetelahDiskon * diskonTambahan);
        
        boolean mendapatDiskon = diskonUtama > 0;
        System.out.println(mendapatDiskon ? "Anda mendapatkan diskon." : "Anda tidak mendapatkan diskon.");
        System.out.printf("Total yang harus dibayar: Rp %.2f\n", totalAkhir);
    }
}
