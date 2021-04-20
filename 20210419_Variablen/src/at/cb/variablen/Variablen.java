package at.cb.variablen;

// PascalCase
public class Variablen {
    public static void main(String[] args){
        // Variable deklarieren
        // Datentyp variablenname;
        // String: Datentyp für einen Text
        // Variablennamen: erster Buchstabe klein - camelCase
        String vorname;
        // Variable initialisieren
        // variablenname = Wert;
        vorname = "M";

        System.out.println("Mein Name ist " + vorname);

        // Variable deklarieren
        // Datentyp Variablenname;
        int zahl1;

        // Variable initialisieren (Wert zuweisen)
        // variablenname = Wert;
        zahl1 = 10;

        // Variable deklarieren und initialisieren
        // Datentyp variablenname = Wert;
        int zahl2 = 23;
        zahl2 = 66;
        zahl2 = zahl2 * 2;

        // float hat 32 bit Speicherplatz
        float x = 2.3f;
        // double hat 64 bit Speicherplatz
        double y = 5.6;

        // char für einen einzelnen Buchstaben
        char buchstabe = 'z';

        System.out.println(buchstabe);
        System.out.println("Wert: " + zahl2 + " buchstabe=" + buchstabe);

        // boolean: Wahrheitswert
        boolean married = false; // true oder false
    }
}
