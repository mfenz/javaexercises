package at.cb.fakultaet;

import java.util.Scanner;

public class Fakultaetsrechner {
    public static void main(String[] args){
        // Objekt der Klasse Fakultaetsrechner erzeugen
        Fakultaetsrechner f = new Fakultaetsrechner();
        // Methode eingabe() des Objekts aufrufen
        f.eingabe();
    }

    /**
     * User-Eingabe der Zahl
     */
    public void eingabe(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Die Fakultät welcher Zahl soll berechnet werden?");

        while (!scanner.hasNextInt()){
            System.out.println("Falsche Eingabe! Bitte wiederholen:");
            // Löschen der falschen Eingabe von der Eingabe
            scanner.nextLine();
        }
        int zahl = scanner.nextInt();
        int fakultaet = fakultaet(zahl);
        System.out.printf("Die Fakultät der Zahl %d ist %d %n", zahl, fakultaet);
    }

    /**
     * Berechnung der Fakultät einer Zahl
     * @param zahl
     * @return die Fakultät der Zahl
     */
    public int fakultaet(int zahl){
        int x = 1;
        for(int i  = 1; i <= zahl; i++){
            x = x * i;
        }

        // Return beendet die Methode, und gibt den angegebenen Wert zurück
        return x;
    }
}
