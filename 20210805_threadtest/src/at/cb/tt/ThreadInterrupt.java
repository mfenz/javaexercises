package at.cb.tt;

public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            // Finde alle Primzahlen bis 1.000.000
            for (int zahl = 2; zahl <= 1000000; zahl++) {
                boolean primzahl = true;
                for (int i = 2; i < zahl; i++) {
                    if (zahl % i == 0) {
                        primzahl = false;
                        break;
                    }
                }
                if (primzahl) {
                    System.out.println(zahl);
                }

                // interrupted??
                if (Thread.interrupted()) {
                    System.out.println("Interrupted ... ");
                    // Methode (damit Thread) beenden
                    return;
                }
            }
        });

        // Thread starten
        t.start();

        // Main-Thread soll 0.5 Sekunden warten
        Thread.sleep(500);

        // interrupt an Thread "t" senden
        t.interrupt();
    }
}
