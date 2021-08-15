package at.cb.jf.rtfakt;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;

public class FaktorielleAsyncMain {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        BigInteger invoke = forkJoinPool.invoke(new FaktorielleTask(0, 50));
        System.out.println(invoke);
    }
}
