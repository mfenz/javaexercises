package at.cb.helloworld;

public class HelloWorld {

    // Main-Methode
    public static void main(String[] args) {
        // Befehl zur Konsolenausgabe
        // Texte immer in Anführungszeichen setzen
        System.out.println("Hello World");
        System.out.println("Das Wetter ist schön!");
        System.out.println(10 + 9832);
        System.out.println("10 + 9832");

        // Werte werden in Variablen gespeichert

        // Variablen-Deklaration
        // Datentyp variablenname;
        // int: Datentyp für eine ganze Zahl
        // alter: selbstgewählter Variablenname
        int alter;

        // Variablen-Initialisierung
        // variablenname = Wert;
        // = Zuweisungsoperator
        alter = 30;

        // Ausgabe der Variable alter
        System.out.println(alter);

        // Variablen-Deklaration
        // Datentyp variablenname;
        // String: Datentyp für Text
        String name;

        // Variable mit Wert initialisieren
        // variablenname = Wert;
        name = "Marc";

        // Ausgabe
        System.out.println(name);

        // Variable deklarieren und initialisieren
        // Datentyp variablenname = Wert;
        // Datentyp float: Kommazahl
        // Datentyp double: Kommazahl
        float temperatur = 5.88f;
        float kontostand = 1234.56f;

        // Die Temperatur beträgt 5.88 °C und der Kontostand ist 1234.56 €
        System.out.println("Die Temperatur beträgt " + temperatur
                + " °C und der Kontostand ist " + kontostand + " €");

        double groesse = 1.81;

        // Wahrheitswerte
        // Datentyp: boolean
        // boolean kann entweder true oder false sein
        boolean zuHeiss = false;
    }

}
