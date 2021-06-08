package at.cb.pyramide;

public class Pyramide {
    // Instanzvariable

    // Jede Pyramide hat eine Höhe
    private int hoehe;

    // Konstruktor
    // public Klassenname
    public Pyramide(int h){
        // Übergabeparameter des Konstruktors auf
        // die Instanzvariable zuweisen
        this.hoehe = h;
    }

    // Methoden
    public void print(){
        int breite = hoehe * 2 - 1;
        for(int zeile = 1; zeile <= hoehe; zeile++){
            for(int spalte = 1; spalte <= breite; spalte++){
                if(spalte >= hoehe - zeile + 1 && spalte <= hoehe + zeile - 1){
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            // Zeilenumbruch nach der Ausgabe der Spalten
            System.out.println();
        }
    }
}
