import java.time.LocalDate;

public class Kalender {
    public static void main(String[] args) {
//        LocalDate today = LocalDate.now();
        LocalDate today = LocalDate.of(2021, 4, 1);
        int year = today.getYear();
        int month = today.getMonthValue();

        Monat monat = new Monat(year, month);
        monat.printMonth();
    }
}
