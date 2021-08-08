package at.cb.tt;

import java.util.ArrayList;
import java.util.List;

public class Primzahlen implements Runnable {
    List<Integer> primzahlen = new ArrayList<>();
    // finde Primzahl zwischen start und ende
    private int start, ende;

    public Primzahlen(int start, int ende) {
        this.start = start; this.ende = ende;

    }

    @Override
    public void run() {
        for (int i = start; i < ende; i++) {
            if (isPrime(i)) {
                primzahlen.add(i);
            }
        }
    }

    //checks whether an int is prime or not.
    boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public List<Integer> getPrimzahlen() {
        return primzahlen;
    }
}
