public class Kalender {
    public static void main(String[] args) {
        int year = 2021;
        int month = 4;

        Monat monat = new Monat(year, month);
        monat.printMonth();
    }
}
