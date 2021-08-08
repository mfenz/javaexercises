package at.cb.tt;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterThread implements Runnable{
    public static AtomicInteger total = new AtomicInteger(0);

    private String name;

    public CounterThread(String name) {
        this.name = name;
    }

    private int counter = 0;

    @Override
    public void run() {
//        int counter = 0;
        while (counter < 1_000_000){
            counter++;
            total.incrementAndGet();
        }
        System.out.printf("%s counter = %d total=%d %n", name, counter, total.get());
    }
}
