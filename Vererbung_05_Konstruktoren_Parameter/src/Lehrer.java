public class Lehrer extends Mensch{
    public Lehrer(String name) {
        // super ruft Konstruktor der
        // parent class Mensch auf
        // Übergabeparameter in Klammern
        super(name);
        System.out.println("Konstruktor" +
                " Lehrer");
    }
}
