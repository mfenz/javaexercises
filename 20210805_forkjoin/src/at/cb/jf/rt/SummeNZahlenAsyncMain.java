package at.cb.jf.rt;

import java.util.concurrent.ForkJoinPool;

public class SummeNZahlenAsyncMain {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        long ergebnis = forkJoinPool.invoke(new SummeNZahlenAsync(0, 10000));
        System.out.println(ergebnis);
    }
}
