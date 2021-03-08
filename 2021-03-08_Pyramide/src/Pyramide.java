public class Pyramide {
    // Instanzvariable
    private int hoehe;

    /**
     * Konstruktor
     */
    public Pyramide(int hoehe){
        this.hoehe = hoehe;
    }

    /**
     * Ausgabe der Pyramide
     */
    public void print(){
        int maxBreite = hoehe * 2 -1;
        int xL = maxBreite / 2;
        int xR = maxBreite / 2;
        for(int zeile = 0; zeile < hoehe; zeile++){
            for(int spalte = 0; spalte < maxBreite; spalte++){
                if(spalte >= xL && spalte <= xR){
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            xL--;
            xR++;
            System.out.println();
        }
    }
}
