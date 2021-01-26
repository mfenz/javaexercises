public class Welt {
    public static void main(String[] args) {
        // Bäume und Menschen können erstellt werden.
        // "Lebewesen" jedoch nicht
        Mensch mensch = new Mensch();
        Baum baum = new Baum();

        // Geht weil Baum ein Lebewesen ist
        Lebewesen eiche = new Baum();
        // Geht weil Mensch von Lebewesen
        // abgeleitet ist
        Lebewesen franz = new Mensch();

        mensch.move();
        baum.move();
        eiche.move();
        franz.move();
    }
}
