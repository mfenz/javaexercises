package at.cb.addierer;

import javax.swing.*;

public class AddiererMain {
    public static void main(String[] args) {

        RechnerBl bl = new RechnerBl();

        // Fenster erzeugen
        AddiererGui gui = new AddiererGui("Addierer", bl);

        // Fenster sichtbar setzen
        gui.setVisible(true);

        // Das Programm soll beendet werden wenn das Fenster geschlossen wird
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Fenster mittig öffnen
        gui.setLocationRelativeTo(null);
    }
}
