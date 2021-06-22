package at.cb.variablen;

public class Datenprofil {
    // Main-Methode
    public static void main(String[] args){
        // Objekt der Klasse erzeugen wo die gewünschte Methode drinnen ist
        // Objekt erzeugen:
        // Klassenname variablenname = new Klassenname();
        Datenprofil dp = new Datenprofil();

        // Über das Objekt der Klasse die Methode aufrufen
        // variablenname.methodenName();
        dp.datenprofilAusgabe();
    }

    /**
     * Methodenname: datenprofilAusgabe
     * Übergabeparameter: ()
     * Block: {  }  <-- Inhalt der Methode (Methodenkörper)
     */
    public void datenprofilAusgabe(){
        // Name, Alter, Adresse, Kontostand, Ehestatus

        // Variable deklarieren
        // Datentyp variablenname;
        String vorname;

        // Variable initialisieren
        // variablenname = Wert;
        vorname = "Marc";

        // Variable deklarieren und initialisieren
        // Datentyp variablenname = Wert;
        String nachname = "Nachname";

        int alter = 5;

        String adresse = "Hauptstrasse 7, 1010 Wien";

        float kontostand = 1234.56f;
        boolean verheiratet = true;

        // Datentyp variablenname = Wert;
        String vollerName = vorname + " " + nachname; // Marc Nachname

        // Wert einer Variable überschreiben
        // variablenname = Wert;
        alter = 20;

        // Mein Name ist {Vorname} {Nachname}.
        // Ich bin {alter} Jahre alt und ich bin {nicht?} verheiratet.
        // Ich wohne in {adresse} und mein Kontostand ist {kontostand}.

        // System.out.println() <-- Ausgabe mit Zeilenumbruch zum Schluss
        // System.out.print() <-- Ausgabe ohne Zeilenumbruch zum Schluss

        System.out.print("Mein Name ist " + vollerName + ". ");
        // String + irgend ein Datentyp ist immer ein String!
        System.out.print("Ich bin " + alter + " Jahre alt und ich bin ");
        // Fallunterscheidung mit if
        // ! <-- NOT Operator
        // Wenn ich NICHT verheiratet bin, dann Ausgabe von "nicht"
        if(!verheiratet){
            System.out.print("nicht ");
        }
        System.out.print("verheiratet.");
        System.out.print("Ich wohne in " + adresse + " und mein Kontostand ist " + kontostand + ".");
    }


}
