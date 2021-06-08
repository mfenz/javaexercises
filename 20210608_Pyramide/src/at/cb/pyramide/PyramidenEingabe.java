package at.cb.pyramide;

import java.util.Scanner;

public class PyramidenEingabe {
    public static void main(String[] args) {
        PyramidenEingabe pe = new PyramidenEingabe();
        pe.eingabe();
    }

    public void eingabe(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Geben Sie die Höhe der Pyramide an:");

            // Eingabe auf Korrektheit prüfen
            while (!scanner.hasNextInt()){
                System.out.println("Das ist keine Höhe! Eingabe wiederholen:");
                // Löschen der bisherigen Eingabe
                scanner.nextLine();
            }
            int hoehe = scanner.nextInt();
            if(hoehe < 0 || hoehe > 10){
                System.out.println("Eingabe ungültig.");
                // continue beendet die aktuelle Ausführung des Schleifenkörper
                continue;
            }

            // Alles OK
            // Objekt der Klasse Pyramide erzeugen
            Pyramide p = new Pyramide(hoehe);
            p.print();
        }
    }
}
