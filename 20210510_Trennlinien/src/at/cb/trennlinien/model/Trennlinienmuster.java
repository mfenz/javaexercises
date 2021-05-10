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
        // For-Schleife über alle Zeilen
        for(int zeile = 0; zeile < zeilen; zeile++){
            // Die aktuelel Zeile ist in Variable zeile

            // for(INIT; SCHLEIFENBEDINGUNG; VERÄNDERUNG){ SCHLEIFENKÖRPER }
            // spalten = 10
            for(int spalte = 0; spalte < spalten; spalte++){
                // Schleifenkörper
                if(zeile % 2 == 0 && spalte % 2 == 0){
                    System.out.print("-");
                } else if(zeile % 2 == 0 && spalte % 2 == 1){
                    System.out.print(" ");
                } else if(zeile % 2 == 1 && spalte % 2 == 0){
                    System.out.print(" ");
                } else {
                    System.out.print("-");
                }
            }
            // Code nach der Schleife
            // Nach der Ausgabe aller Spalten --> Zeilenumbruch machen
            System.out.println();
        }
    }
}
