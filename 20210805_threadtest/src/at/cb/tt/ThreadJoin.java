package at.cb.tt;

public class ThreadJoin {
    public static void main(String[] args)
            throws InterruptedException {
        Thread t = new Thread(() -> {
        });

        // Weiteren Thread starten
        t.start();

        // Main-thread wartet nun
        t.join();
    }
}
