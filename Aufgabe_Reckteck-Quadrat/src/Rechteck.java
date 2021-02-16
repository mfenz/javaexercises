public class Rechteck {
    private int zeilen; // Instanzvariable
    private int spalten;

    // Konstruktor
    public Rechteck(int zeilen, int spalten){
        this.zeilen = zeilen;
        this.spalten = spalten;
    }

    public void print(){
        int anzZeichen = 0;
        for(int zeile = 0; zeile < zeilen; zeile++){
            // für jede neue Zeile mit Spalte 0 starten
            for(int spalte = 0; spalte < spalten; spalte++){
                anzZeichen++;
                if(anzZeichen % 3 == 0){
                    System.out.print('O');
                } else {
                    System.out.print('X'); // Einzelnes Zeichen ohne Umbruch ausgeben
                }
            }
            System.out.println(); // Neue Zeile nachdem die Spalten ausgegeben wurden
        }
    }

}
