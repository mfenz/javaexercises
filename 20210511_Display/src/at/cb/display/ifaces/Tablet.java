package at.cb.display.ifaces;

// Tablet implementiert Interface Darstellbar
public class Tablet implements Darstellbar{

    // Methode des Interface implementieren
    @Override
    public void darstellen(String str) {
        // Inhalt einfach auf Konsole ausgeben
        System.out.println(str);
    }
}
