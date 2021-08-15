package at.cb.jf;

import at.cb.jf.rt.QuersummeTask;

import java.util.concurrent.ForkJoinPool;

public class QuersummeMain {
    public static void main(String[] args) {
        // Common Pool erzeugen
        ForkJoinPool pool = ForkJoinPool.commonPool();

        // invoke --> async Task ausführen, auf Ergebnis warten
//        Integer result = pool.invoke(
//                new QuersummeTask("999999999999999999999")); // 21 * 9
        Integer result = pool.invoke(
                new QuersummeTask("12")); // 21 * 9

        // Ergebnis ausgeben
        System.out.println(result); // 21 * 9 = 189
    }
}
