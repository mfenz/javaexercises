package at.cb.potenzieren;

import java.util.Scanner;

public class Potenzrechner {
    public static void main(String[] args) {
        // new Potenzrechner() erstellt ein
        // Objekt der Klasse Potenzrechner
        Potenzrechner p = new Potenzrechner();
        // Mit dem Punkt-Operator auf Objekte zugreifen
        p.potenzieren();
    }

    public void potenzieren(){
        // System.in ist der Input-Stream (Konsole)
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte die Basis eingeben:");
        int basis = scanner.nextInt();

        System.out.println("Bitte die Hochzahl eingeben:");
        int hochzahl = scanner.nextInt();

        int zwischenergebnis = 1;
        for(int i = 1; i <= hochzahl; i++){
            // Schleifenkörper
            zwischenergebnis = basis * zwischenergebnis;
        }

        System.out.printf("%d hoch %d = %d %n", basis, hochzahl, zwischenergebnis);
    }
}
