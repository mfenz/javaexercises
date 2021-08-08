package at.cb.tt;

public class CounterThreadMain {
    public static void main(String[] args) throws InterruptedException {
        CounterThread ct = new CounterThread("A");
        Thread t1 = new Thread(ct);
        Thread t2 = new Thread(ct);
        Thread t3 = new Thread(ct);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(CounterThread.total);
    }
}
