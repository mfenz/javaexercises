import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zahlen {
    // Instanzvariable
    // gehören immer zu einem Objekt einer Klasse
    private int[] zahlen = new int[478656878];

    public static void main(String[] args) {
        Zahlen z = new Zahlen();
        z.fuellen();
        z.print(z.getZahlen());
        int[] even = z.getEven(z.getZahlen());
        z.print(even);
    }
    private int[] getEven(int[] zahlen){
        List<Integer> even = new ArrayList<>();
        for(int i = 0; i < zahlen.length; i++){
            if(zahlen[i] % 2 == 0){
                even.add(zahlen[i]);
            }
        }
        // even-Liste in ein Array umwandeln
        int[] result = new int[even.size()];
        for(int i = 0; i < even.size(); i++){
            result[i] = even.get(i);
        }
        // result-Array zurückgeben
        return result;
    }
    private void fuellen(){
        Random random = new Random();
        for(int i = 0; i < zahlen.length; i++){
            // 1) Zufallswert erzeugen
            int num = random.nextInt();
            // Array an der Stelle i mit Zufallszahl initialisieren
            zahlen[i] = num;
        }
    }
    private void print(int[] zahlen){
        for(int j : zahlen){
            System.out.print(j + ", ");
        }
//        for(int i = 0; i < zahlen.length; i++){
//            System.out.print(zahlen[i] + ", ");
//        }
        System.out.println();
    }

    // Konstruktor
    public Zahlen(){
    }

    /**
     * public <-- access modifier (für die Sichtbarkeit der Methode)
     * int[] <-- Rückgabetyp
     * getZahlen <-- Methodenname
     * { Methodenkörper }
     */
    public int[] getZahlen(){
        return zahlen;
    }
}
