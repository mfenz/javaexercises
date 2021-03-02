import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Monat {

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset
    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED

    private int year;
    private int month;

    public Monat(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public void printMonth(){
        LocalDate today = LocalDate.now();

        // LocalDate initialisieren mit dem ersten des Monats
        LocalDate day = LocalDate.of(year, month, 1);
        LocalDate firstOfNextMonth = day.plusMonths(1);

        System.out.println("First day:");
        System.out.println(day);
        System.out.println("First of next Month");
        System.out.println(firstOfNextMonth);
        System.out.println();

        // Day auf Montag initialisieren
        while(day.getDayOfWeek().getValue() != 1){
            day = day.minusDays(1);
        }
        // firstOfNextMonth auf nächsten Montag verschrieben
        while(firstOfNextMonth.getDayOfWeek().getValue() != 1){
            firstOfNextMonth = firstOfNextMonth.plusDays(1);
        }

        System.out.println("Kalender");

        // Wochentage Header ausgeben
        for(int i = 0; i < 7; i++){
            LocalDate weekday = day.plusDays(i);
            String displayName = weekday.getDayOfWeek().getDisplayName(TextStyle.SHORT_STANDALONE, Locale.GERMAN);
            System.out.printf("%-3s", displayName);
        }
        System.out.println();

        // solange unser aktueller Tag nicht der erste Tag des nächsten Monats ist
        while (!day.isEqual(firstOfNextMonth)){
            if(day.isEqual(today)){
                System.out.printf("%s%2d%s ", RED, day.getDayOfMonth(), RESET);
            } else {
                System.out.printf("%2d ", day.getDayOfMonth()); // Nur Tag (nicht Monat... ausgeben)
            }

            // Prüfen ob aktueller Tag ein Sonntag ist
            if(day.getDayOfWeek().getValue() == 7){
                // wenn Sonntag, dann Zeilenumbruch
                System.out.println();
            }

            // Einen Tag weiter
            day = day.plusDays(1);
        }
    }
}
