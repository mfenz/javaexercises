package at.cb.jf;

import java.util.concurrent.ForkJoinPool;
public class ArrayBerechnungAsync {
    public static void main(String[] args) {
        // Daten-Array deklarieren und initialisieren
        double[] x = new double[500_000_000];

        // Recursive Task erstellen
        ArrayRA r = new ArrayRA(x, 0, x.length-1);

        // RecursiveTask an ForkJoin-Pool übergeben (und starten)
        new ForkJoinPool().invoke(r);

        System.out.println("Berechnung fertig!");
    }
}
