package at.cb.helloworld;

public class HelloWorld {
    // Main-Methode (Einstiegspunkt in das Programm)
    public static void main(String[] args) {
        // Hello World auf der Konsole ausgeben

        // System.out.println() gibt den gegebenen Text aus, zum Schluss einen Zeilenumbruch
        System.out.println("Hello World");
        System.out.println("Mein Name ist <Name>");

        // System.out.print() macht zum Schluss keinen Zeilenumbruch
        System.out.print("Das ");
        System.out.print("ist");
        System.out.print(" ");
        System.out.print("ein");
        System.out.print("Text");
        System.out.println();

        // Variablen
        // Art der Daten --> Datentypen
        // Variable deklarieren: datentyp variablenname;
        // int --> Datentyp für eine ganze Zahl
        // Reserviert einen Speicherbereich für eine ganze Zahl
        // und mit dem Variablennamen a kann man auf den Speicherbereich zugreifen
        int a; // Variable deklariert
        // variablenname = wert;
        a = 5; // Variable initialisiert

        int b = 7; // Variable b deklariert, und gleich initialisiert

        int c = a + b;
        // 5 + 7 = 12
        System.out.println(a + " + " + b + " = " + c);

        // int <-- Datentyp für ganze Zahl
        // float bzw. double <-- Datentypen für Fließkommazahlen (Kommazahlen)
        // String <-- Zeichenketten (Texte)
        // boolean <-- Wahrheitswerte (true/false)
        // char <-- ein einzelnes Zeichen, z. B. 'Z'

        int alter = 30;
        float aussentemperatur = 12.55f; // f bei float
        double kontostand = 1234.56; // double benötigt kein f
        // float: 32 bit Speicherplatz
        // double: 64 bit Speicherplatz

        String name = "Mname"; // String-Werte sind immer in doppelten Anführungszeichen
        String n2 = "name";
        String zusammen = name + n2; // + Operator zur Verkettung von Zeichen
        zusammen = name + " nix";

        boolean verheiratet = true; // oder false
        // String <-- Zeichenketten
        // char <-- einzelnes Zeichen (muss genau ein Zeichen
        char geschlecht = 'm';
        geschlecht = 'w';
    }
}
