import java.util.Random;

public class Textdiagramm {
    private int seitenlaenge; // Instanzvariable

    // Konstruktor
    public Textdiagramm(int seitenlaenge){
        this.seitenlaenge = seitenlaenge;
    }

    // Methode
    public void printTextdiagramm(){
        // wird benötigt um Zufallszahlen zu erzeugen
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
//                    int randomZahl = random.nextInt(9999-1000)+1000;
//                    System.out.printf(" %d ", randomZahl);
                    System.out.print(" ");
                    for(int i = 0; i < 4; i++){
                        char x = randomChar();
                        System.out.printf("%c", x);
                    }
                    System.out.print(" ");
                }
            }

            // Zeilenumbruch nach seitenlaenge Spalten
            System.out.println("|");
        }
    }

    private char randomChar(){
        Random random = new Random();
        if((random.nextInt(2-0)+0) == 0){
            return randomCharLowercase();
        } else {
            return randomCharUppercase();
        }
    }

    private char randomCharLowercase(){
        Random random = new Random();
        char x = (char) (random.nextInt(122-97) + 97);
        return x;
    }

    private char randomCharUppercase(){
        Random random = new Random();
        char x = (char) (random.nextInt(90-65) + 65);
        return x;
    }


}
