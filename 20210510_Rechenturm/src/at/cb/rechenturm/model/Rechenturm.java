package at.cb.rechenturm.model;

public class Rechenturm {
    // Instanzvariable
    private int reihe;

    // Konstruktor
    // Übergabeparameter: int reihe
    public Rechenturm(int reihe){
        // Übergabeparameter der Instanzvariable zuweisen
        // this.reihe <-- Auf Instanzvariable verweisen
        // Instanzvariable = Übergabeparameter
        this.reihe = reihe;
    }

    public void print(){
        // Zeile für Zeile
        for(int i = 1; i <= 10; i++){
            System.out.printf("%2d x %d = ", i, reihe);

            for(int j = 1; j <= i; j++){
                System.out.print(reihe);
                // Solange wir nicht beim letzten sind, plus ausgeben
                if(j != i){
                    System.out.print(" + ");
                }
            }

            int ergebnis = i * reihe;
            // Zeilenumbruch zum Schluss
            System.out.println(" = " + ergebnis);
        }
    }
}
