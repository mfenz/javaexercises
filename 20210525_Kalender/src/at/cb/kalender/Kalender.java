package at.cb.kalender;

import at.cb.kalender.model.Monat;

import java.util.Scanner;

public class Kalender {
    public static void main(String[] args) {
        // Objekt der Klasse Kalender
        Kalender k = new Kalender();
        // Methode monatsEingabe() aufrufen
        k.monatsEingabe();
    }

    private void monatsEingabe(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte Monat eingaben (1-12):");
        int monat = scanner.nextInt();

        System.out.println("Bitte Jahr eingeben:");
        int jahr = scanner.nextInt();

        // Objekt der Klasse Monat erzeugen
        Monat m = new Monat(monat, jahr);
        m.print();
    }
}
