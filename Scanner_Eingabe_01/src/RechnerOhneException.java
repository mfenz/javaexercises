import java.util.Scanner;

public class RechnerOhneException {
    public static void main(String[] args) {
        RechnerOhneException r = new RechnerOhneException();
        r.eingabe();
    }

    public void eingabe(){
        // Scanner Objekt erstellen
        // System.in <-- Keyboard input einlesen
        Scanner scanner = new Scanner(System.in);

        // User erklären was zu tun ist:
        System.out.println("Bitte eine ganze Zahl eingeben:");
        // int einlesen und auf Variable "a" speichern
        int a = scanner.nextInt();

        System.out.println("Dankeschön, eingabe war: " + a);
    }
}
