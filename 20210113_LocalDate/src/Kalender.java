import java.time.DayOfWeek;
import java.time.LocalDate;

public class Kalender {
    public static void main(String[] args) {
        // heute
        LocalDate today = LocalDate.now();
        /*LocalDate start = LocalDate.of(2021, 1, 1);
        DayOfWeek dayOfWeek = start.getDayOfWeek();
        System.out.println(start + " " + dayOfWeek + " " + dayOfWeek.getValue());
        LocalDate startPlus1 = start.plusDays(1);
        DayOfWeek dayOfWeekPlus1 = startPlus1.getDayOfWeek();
        System.out.println(startPlus1 + " " + dayOfWeekPlus1);*/

        LocalDate day = LocalDate.of(2021, 1, 1);
        while (day.getMonthValue() == 1){
            System.out.println(day);
            day = day.plusDays(1);
        }
    }
}
