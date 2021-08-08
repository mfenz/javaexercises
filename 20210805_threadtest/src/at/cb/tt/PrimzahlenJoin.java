package at.cb.tt;

public class PrimzahlenJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Primzahlen(10, 20));
        t.start();
        t.join();

        Thread berechnung = new Thread(() -> {
            // Code ...
        });

        // Thread als Daemon-Thread markieren
        berechnung.setDaemon(true);

        // Thread starten
        berechnung.start();

        // wenn nun der Main-Thread beendet wird
        // wird auf der Daemon-Thread beendet
    }
}
