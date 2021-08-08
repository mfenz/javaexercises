package at.cb.tt;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class ThreadInstanzvariablen {
    private static class Start implements Runnable {
        // Startzeit als Instalzvariable
        private Instant startZeit;
        @Override
        public void run() {
            // Startzeit setzen
            this.startZeit = Instant.now();
            try {
                // 10 Sekunden warten
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
            }
            // Startzeit ausgeben
            System.out.printf("Thread %d startZeit=%s%n", Thread.currentThread().getId(), startZeit);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Start runnable = new Start();
        for(int i = 0; i < 3; i++){
            new Thread(runnable).start();
            // Alle 2 Sekunden einen Thread starten
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
