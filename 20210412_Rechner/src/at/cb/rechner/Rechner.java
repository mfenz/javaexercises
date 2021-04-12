package at.cb.rechner;

// Das ist die Klasse Rechner
public class Rechner {
    // main-Methode
    public static void main(String[] args) { // Block öffnen
        // Variablen deklarieren (datentyp variablenname;)
        // Variablennamen beginnen immer mit einem Kleinbuchstaben
        int zahl1;
        int zweiteZahl;

        // Variablen initialisieren
        zahl1 = 5;
        zweiteZahl = 10;

        // Rechnung durchführen und Ergebnis speichern
        int ergebnis = zahl1 + zweiteZahl;

        // Ergebnis ausgeben
        System.out.println("Das Ergebnis ist: " + ergebnis);

        // String ist der Datentyp für einen Text
        String name = "Marc";
        System.out.println("Mein Name ist " + name);

    } // Block schließen
}
