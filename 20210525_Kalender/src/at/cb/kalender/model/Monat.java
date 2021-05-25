package at.cb.kalender.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Monat {
    // Instanzvariablen
    private int monat;
    private int jahr;

    // Konstruktor
    public Monat(int m, int j){
        // Parameter auf die Instanzvariablen zuweisen
        this.monat = m;
        this.jahr = j;
    }

    public void print(){
        // Logik zur Ausgabe eines Kalendermonats

        LocalDate firstOfMonth = LocalDate.of(jahr, monat, 1);
        System.out.println("Erster Tag des Monats: " + firstOfMonth.getDayOfWeek().getValue());

        // So lange zurückgeben bis wir beim Montag sind
        LocalDate firstOfWeek = LocalDate.of(jahr, monat, 1);
        while (firstOfWeek.getDayOfWeek().getValue() != 1){
            firstOfWeek = firstOfWeek.minusDays(1);
        }

        // Wochentage Header ausgeben
        for(int i = 0; i < 7; i++){
            LocalDate weekday = firstOfWeek.plusDays(i);
            String name = weekday.getDayOfWeek().getDisplayName(TextStyle.SHORT_STANDALONE,
                    Locale.GERMAN);
            System.out.printf(" %-3s|", name);
        }
        System.out.println();

        // Letzten Tag der Ausgabe bestimmen
        LocalDate lastDay = firstOfMonth.plusMonths(1).minusDays(1);
        while (!lastDay.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
            lastDay = lastDay.plusDays(1);
        }
        // lastDay soll jedoch nicht mehr dargestellt werden!
        // erste Tag der nicht mehr dargestellt wird
        lastDay = lastDay.plusDays(1);

        // Kalender ausgeben
        // von firstOfWeek bis lastDay alle Tage ausgeben
        LocalDate day = firstOfWeek;
        while (!day.equals(lastDay)){

            // Nur Tage vom gewünschten Monat ausgeben
            if(day.getMonthValue() == monat){
                System.out.printf(" %2d |", day.getDayOfMonth());
            } else {
                System.out.print("    |");
            }

            // Zeilenumbruch nach jedem Sonntag
            if(day.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                System.out.println();
            }

            // Einen Tag weitergehen
            day = day.plusDays(1);
        }


    }
}
