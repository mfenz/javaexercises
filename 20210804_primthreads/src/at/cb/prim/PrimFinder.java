package at.cb.prim;

import java.util.List;

public class PrimFinder extends Thread {
    private int min;
    private int max;

    private List<Integer> primzahlen;

    public PrimFinder(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {

    }

    public List<Integer> getPrimzahlen() {
        return primzahlen;
    }
}
