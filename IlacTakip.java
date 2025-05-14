package ilaçTakipSistemi;
import java.util.ArrayList;
import java.util.Scanner;


class Ilac {
    String isim;
    String barkod;
    int adet;

    public Ilac(String isim, String barkod, int adet) {
        this.isim = isim;
        this.barkod = barkod;
        this.adet = adet;
    }

    public void yazdir() {
        System.out.println("İlaç Adı: " + isim + ", Barkod: " + barkod + ", Adet: " + adet);
    }
}

public class IlacTakip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Ilac> ilacListesi = new ArrayList<>();

        while (true) {
            System.out.println("\n--- İlaç Takip Sistemi ---");
            System.out.println("1. İlaç Ekle");
            System.out.println("2. İlaçları Listele");
            System.out.println("3. İlaç Ara");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    System.out.print("İlaç adı: ");
                    String isim = scanner.nextLine();
                    System.out.print("Barkod: ");
                    String barkod = scanner.nextLine();
                    System.out.print("Adet: ");
                    int adet = scanner.nextInt();
                    scanner.nextLine(); 
                    ilacListesi.add(new Ilac(isim, barkod, adet));
                    System.out.println("İlaç eklendi.");
                    break;
                case 2:
                    System.out.println("--- İlaç Listesi ---");
                    for (Ilac i : ilacListesi) {
                        i.yazdir();
                    }
                    break;
                case 3:
                    System.out.print("Aranacak ilaç adı: ");
                    String aranan = scanner.nextLine();
                    boolean bulundu = false;
                    for (Ilac i : ilacListesi) {
                        if (i.isim.equalsIgnoreCase(aranan)) {
                            i.yazdir();
                            bulundu = true;
                        }
                    }
                    if (!bulundu) {
                        System.out.println("İlaç bulunamadı.");
                    }
                    break;
                case 4:
                    System.out.println("Programdan çıkılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim. Tekrar deneyin.");
            }
        }
    }
}
