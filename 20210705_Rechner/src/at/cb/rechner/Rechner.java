package at.cb.rechner;

public class Rechner {

    public static void main(String[] args){
        // Objekt der Klasse Rechner
        Rechner r = new Rechner();
        // rechnen Methode aufrufen
        r.rechnen();
    }

    public void rechnen(){
        double x = subtrahieren(15.0, 5.0);
        System.out.printf("Ergebnis vom Subtrahieren: %f%n", x);
        System.out.printf("Ergebnis vom Subtrahieren: %f%n", subtrahieren(15.0, 5.0));

        x = addieren(x, 3.0, 7.0, -40.0);
        System.out.printf("Ergebnis vom Addieren: %f%n", x);

        x = halbieren(x);
        System.out.printf("Ergebnis vom Halbieren: %f%n", x);
    }

    // Addition: beliebig viele Werte addieren
    // Sichtbarkeit Rückgabedatentyp methodenname(Übergabeparameter){  }
    // Rückgabedatentyp double: Methode muss genau einen Wert vom Typ double zurückgeben
    public double addieren(double... zahlen){
        double summe = 0;
        for(int i = 0; i < zahlen.length; i++){
            summe += zahlen[i];
        }
        // Methode beenden, Wert zurückgeben der auf "summe" steht
        return summe;
    }

    // Rückgabewert <--> Übergabeparameter
    // Methode subtrahieren
    // Subtrahiert zwei Zahlen (a - b)
    // a und b <-- Übergabeparameter
    // Ergebnis zurückgeben <-- Rückgabewert
    // Sichtbarkeit Rückgabedatentyp methodenname(Übergabeparameter){  }
    public double subtrahieren(double a, double b){
        // zahl a minus zahl b
        double ergebnis = a - b;

        // return: beendet die Methode
        // return ergebnis; <-- beende die Methode, und gebe den Wert der Variable
        // ergebnis zurück
        return ergebnis;
    }

    public double halbieren(double a){
        return a / 2.0;
    }

}
