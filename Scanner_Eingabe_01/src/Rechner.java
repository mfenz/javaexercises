import java.util.Scanner;
public class Rechner {
    public static void main(String[] args) {
        Rechner rechner = new Rechner();
        rechner.eingabe();
    }
    public void eingabe(){
        // Scanner Objekt erstellen
        // System.in <-- Keyboard input einlesen
        Scanner scanner = new Scanner(System.in);

        // User erklären was zu tun ist:
        System.out.println("Bitte eine ganze Zahl eingeben:");
        // int einlesen und auf Variable "a" speichern
        int a = scanner.nextInt();

        // User erklären was zu tun ist:
        System.out.println("Bitte den Multiplikator eingeben:");
        // float einlesen und auf Variable "b" speichern
        float b = scanner.nextFloat();

        // Ergebnis berechnen
        float ergebnis = a + b;
        System.out.printf("%d x %f = %f", a, b, ergebnis);
    }
}
