package at.cb.rechenturm;

import at.cb.rechenturm.model.Rechenturm;

import java.util.Scanner;

public class RechenturmTest {
    public static void main(String[] args) {
        // Objekt der Klasse RechenturmTest erzeugen
        RechenturmTest rt = new RechenturmTest();
        rt.doUserInput();
    }

    public void doUserInput(){
        // Scanner für User-Eingabe
        Scanner scanner = new Scanner(System.in);
        // User sagen was zu tun ist
        System.out.println("Bitte die Reihe eingeben:");
        // Reihe von User eingeben lassen
        int reihe = getNumber(scanner);

        // Neues Objekt der Klasse Rechenturm erzeugen
        Rechenturm rechenturm = new Rechenturm(reihe);
        // Rechenturm auf der Konsole ausgeben
        rechenturm.print();
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
    public int getNumber(Scanner scanner){
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
