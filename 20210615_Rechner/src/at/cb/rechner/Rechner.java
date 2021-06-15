package at.cb.rechner;

public class Rechner {
    // Main-Methode
    public static void main(String[] args) {
        // Objekt der Klasse Rechner erzeuge
        // Klassenname variablenname = new Klassenname();
        Rechner r = new Rechner();

        // Über das Objekt die Methode aufrufen
        // variablenname.methodenname()
        r.rechnen();
    }

    // Methode rechnen()
    public void rechnen() {
        // Inhalt der Methode rechnen()

        int hoehe = 10;
        int breite = 4;
        int flaeche = hoehe * breite;
        int tiefe = 3;
        int volumen = flaeche * tiefe;

        System.out.println("Fläche: " + flaeche);
        System.out.println("Volumen: " + volumen);
    }
}
