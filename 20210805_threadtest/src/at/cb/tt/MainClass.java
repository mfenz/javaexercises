package at.cb.tt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainClass {
    public static void main(String[] args) {
        AktuelleUhrzeitThread thread = new AktuelleUhrzeitThread();
        thread.start(); // Thread starten


        // Thread erzeugen, Runnable übergeben
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    LocalDateTime now = LocalDateTime.now();
                    System.out.printf("Es ist %s.%n",
                            now.format(DateTimeFormatter.ISO_DATE_TIME));
                    try {
                        // Eine Sekunde warten
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // Thread starten
        t.start();

//        AktuelleUhrzeitRunnable r = new AktuelleUhrzeitRunnable();
//        Thread t = new Thread(r);
//        t.start(); // Thread starten

    }
}
