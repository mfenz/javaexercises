package at.cb.rechner;

public class Rechner {
    // Main-Methode (Einstiegspunkt ins Programm)
    public static void main(String[] args) {
        // Objekt der Klasse erzeugen
        // Klassanname variablenname = new Klassenname();
        Rechner r = new Rechner();

        // Methode des Objekts aufrufen
        // variablenname.methodenname();
        r.rechnen();
    }

    // Methode mit dem Namen rechnen angelegt
    // Methodennamen sind frei wählbar, beginnen mit einem Kleinbuchstaben
    public void rechnen() {
        int laenge = 10;
        int breite = 5;

        int flaeche = laenge * breite;

        // Fläche: 10 x 5 = 50
        System.out.println("Fläche: " + laenge + " x " + breite + " = " + flaeche);
    }
}
