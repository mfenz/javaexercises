// Java Beispiel
public class Addierer {
    static void rechnen(){
        int ergebnis = Addierer.add(5, 10);
    }

    static int add(int a, int b){
        return a + b;
    }
    // Keine Parameter
    static int zero(){
        return 0;
    }

    public static void main(String[] args) {
        // Aufruf der statischen Funktion
        // Klassenname.methodenname(argumente);
        Addierer.add(1, 2);
        // Keine Argumente
        Addierer.zero();
    }
}
