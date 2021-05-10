package at.cb.trennlinien.model;

public class Trennlinienmuster {
    // Instanzvariablen
    private int zeilen;
    private int spalten;

    /**
     * Konstruktor
     * Werte kommen über Parameter in den Konstruktor
     * Parameter den Instanzvariablen zuweisen
     */
    public Trennlinienmuster(int zeilen, int spalten){
        // this.zeilen referenziert auf Instanzvariable
        // = zweilen weist der Instanzvariable den Wert des Paramters zu
        this.zeilen = zeilen;
        this.spalten = spalten;
    }

    /**
     * Ausgabe des Trennlinienmusters
     */
    public void print(){


    }
}
