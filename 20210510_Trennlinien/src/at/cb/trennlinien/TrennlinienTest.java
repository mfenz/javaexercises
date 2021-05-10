package at.cb.trennlinien;

import at.cb.trennlinien.model.Trennlinienmuster;

import java.util.Scanner;

public class TrennlinienTest {
    public static void main(String[] args) {
        // Scanner verbindet das Programm mit der Eingabe in der Konsole
        Scanner scanner = new Scanner(System.in);

        // User sagen was zu tun ist
        System.out.println("Anzahl der Zeilen eingeben:");

        // Methode aufrufen (gibt die eingegebene Zahl zurück)
        // Speichert das Ergebnis des Methodenaufrufs in Variable zeilen
        int zeilen = getNumber(scanner);

        System.out.println("Anzahl der Spalten eingeben:");
        int spalten = getNumber(scanner);

        // Objekt der Klasse Trennlinienmuster erzeugen und auf Var. muster speichern
        Trennlinienmuster muster = new Trennlinienmuster(zeilen, spalten);
        // Aufruf der Methode print() für Objekt muster
        // variablenname punkt methodennamen()
        muster.print();

    }

    /**
     * Liest eine Zahl über die Konsole ein
     * public: Diese Methode kann auch in anderen Klassen aufgerufen werden
     * static: weil Methode von static main aufgerufen wird (von static nur auf static)
     * int: Rückgabedatentyp (gibt einen Wert des Datentyps int zurück an aufrufende Methode)
     * (Scanner scanner) <-- Parameter (Übergabeparameter), Werte die wir der Methode beim Aufruf mitgeben
     * @param scanner
     * @return
     */
    public static int getNumber(Scanner scanner){
        // solange die Eingabe falsch ist, Eingabe wiederholen
        // Schleifenbedingung muss true sein, wenn die Eingabe falsch ist
        // scanner.hasNextInt() <-- true wenn Eingabe korrekt ist
        // scanner.hasNextInt() <-- false wenn Eingabe falsch ist
        // ! <-- Rufzeichenoperator (invertiert true bzw. false)
        while (!scanner.hasNextInt()){
            // Falsche Eingabe löschen
            scanner.nextLine(); // Input von Eingabe lesen, aber nix damit tun
            // User über falsche Eingabe informieren
            System.out.println("Es wurde keine Zahl eingegeben! Bitte die Eingabe wiederholen:");
            // danach Eingabe wiederholen (durch Schleifenbedingung)
        }
        // Auf User-Eingabe warten, und die Eingabe auf Variable
        // zeilen speichern
        int eingabeZahl = scanner.nextInt();
        return eingabeZahl; // Gibt den Wert der Variable eingabeZahl zurück
        // return scanner.nextInt();
    }

}
