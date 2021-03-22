public class Rechner {
    public static void main(String[] args){
        // Variable deklarieren
        // Datentyp Variablenname
        int zahl;
        // Variable initialisieren
        // Initialisieren mit = dem Zuweisungsoperator
        zahl = 456;

        // Variable deklarieren und initialisieren
        int x = 60;
        x = 700;
        x = zahl;


        int alter = 20;
        int alterSehrAlt = 101;
        int differenz = alter - alterSehrAlt;
        System.out.println("Die Differenz ist:");
        System.out.println(differenz);
        System.out.println("Die Differenz ist: " + differenz);
        String vorname = "Marc";
        System.out.println("Mein Name ist: " + vorname + " Differenz: " +differenz);
        double fuellstand = 56.32;
        boolean leer = false;
    }
}
