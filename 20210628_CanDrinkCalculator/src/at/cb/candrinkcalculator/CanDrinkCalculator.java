package at.cb.candrinkcalculator;

import java.util.Scanner;

public class CanDrinkCalculator {
    /**
     * Lesen Sie das Alter des Users ein. Bestimmen Sie anhand der Eingabe ob
     * die Person berechtigt ist Alkohol zu trinken. Personen jünger als 16
     * Jahre sind nie berechtigt Alkohol zu trinken (Ausgabe: “No.”).
     * Personen zwischen 16 und 20 Jahre dürfen Alkohol trinken,
     * jedoch nicht in den USA. Fragen Sie die Person in welchem Land sie
     * sich befindet. Sollte sich die Person in den “USA” aufhalten ist die
     * Ausgabe “No.”, ansonsten “Yes.”. Personen ab 21 Jahre dürfen überall
     * Alkohol trinken (Ausgabe: “Yes, welcome.”).
     * @param args
     */
    public static void main(String[] args) {
        // Methodenkörper der Main-Methode

        // Objekten erzeugen (um von static-Methode eine nicht-static Methode aufzurufen)
        // Klassenname variablenname = new Klassenname();
        CanDrinkCalculator calc = new CanDrinkCalculator();

        // Methodenaufruf
        // variablenname.methodenname();
        calc.calculate();

        //calc.ausgabe();
    }

    public void ausgabe(){
        // Formatierte Ausgabe mit System.out.printf(formatierungsstring, werte ...);
        float kontostand = 1234.1f;
        int alter = 30;
        String name = "Hansi";
        float abbuchung = 750.0f;
        // Platzhalter: starten immer mit %
        // %f <-- float, double
        // %.2f <-- float oder double mit 2 Nachkommastellen
        // %d <-- int
        // %s <-- String
        // %10s <-- String-Ausgabe soll mind. 10 Zeichen in Anspruch nehmen (Rest mit LZ auffüllen)
        // %n <-- Zeilenumbruch
        System.out.printf("Konto für %-10s: %.2f Alter: %-4d %n", name, kontostand, alter);

        // %8.2f <-- 5 Vorkommastellen, 2 Nachkommastellen
        // (2 Nachkomma + Dez.Punkt + Vorkommastellen) = 8
        System.out.printf("Abbuchung: %8.2f %n", abbuchung);
    }

    public void calculate(){
        // Programmlogik kommt hier rein

        // User-Eingaben über die Konsole: Scanner
        // Objekt der Klasse Scanner erzeugt
        Scanner scanner = new Scanner(System.in);

        // Systemausgabe
        System.out.println("Bitte das Alter eingeben:");

        // Usereingabe
        int alter = scanner.nextInt();
        // damit die Eingabe des Alters funktioniert
        scanner.nextLine();

        System.out.println("Es wurde " + alter + " als Alter eingegeben.");

        // Wenn .... dann ... --> if Verzweigungen
        if(alter < 16) {
            System.out.println("No.");
        }
        if(alter >= 16 && alter <= 20){
            System.out.println("Wo wohnen Sie (Land)?");
            // User-Eingabe
            String land = scanner.nextLine();

            // String Vergleiche nur mit .equals()
            if(land.equals("USA")){
                // wird nur ausgeführt wenn land USA ist
                System.out.println("No.");
            } else {
                // wird nur ausgeführt wenn land NICHT USA ist
                System.out.println("Yes.");
            }
        }
        if(alter >= 21){
            System.out.println("Yes");
        }
    }
}
