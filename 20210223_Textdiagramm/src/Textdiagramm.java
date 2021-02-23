import java.util.Random;

public class Textdiagramm {
    private int seitenlaenge; // Instanzvariable

    // Konstruktor
    public Textdiagramm(int seitenlaenge){
        this.seitenlaenge = seitenlaenge;
    }

    // Methode
    public void printTextdiagramm(){
        Random random = new Random();

        for(int zeile = 0; zeile < seitenlaenge; zeile++){
            for(int spalte = 0; spalte < seitenlaenge; spalte++){
                System.out.print("|");
                // Zeile und Spalte ausgeben
//                System.out.printf(" %2d%2d ", zeile, spalte);
                if(zeile == spalte){
                    System.out.print(" CODE ");
                } else {
                    // Random Zahl generieren: https://stackoverflow.com/a/5271613
                    int randomZahl = random.nextInt(9999-1000)+1000;
                    System.out.printf(" %d ", randomZahl);
                }
            }

            // Zeilenumbruch nach seitenlaenge Spalten
            System.out.println("|");
        }
    }
}
