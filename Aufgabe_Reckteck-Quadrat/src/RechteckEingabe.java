import java.util.Scanner;

// Fabrik
public class RechteckEingabe {
    public static void main(String[] args) {
        RechteckEingabe rechteckEingabe = new RechteckEingabe();
        rechteckEingabe.eingabe();
    }

    public void eingabe(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie die Anzahl der Zeilen an: ");
        int zeilen = scanner.nextInt();
        System.out.println("Geben Sie die Anzahl der Spalten an: ");
        int spalten = scanner.nextInt();

        if(zeilen < 0 || zeilen > 20 || spalten < 0 || spalten > 20){
            System.out.println("Die Eingabe war leider nicht korrek.");
            System.exit(0); // Programm beenden
        }

        // new Reckteck ruft den Konstruktor auf
        Rechteck r1 = new Rechteck(zeilen, spalten);
        r1.print();
    }
}
