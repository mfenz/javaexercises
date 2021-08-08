package at.cb.tt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// von Thread ableiten
public class AktuelleUhrzeitThread extends Thread{
    // run() überschreiben!
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
}
