package at.cb.j2e;

import javax.swing.*;

public class Gui {
    public static void main(String[] args) {
        /* Erzeugung eines neuen Frames mit dem
           Titel "Beispiel JFrame " */
        JFrame meinFrame = new JFrame("Beispiel JFrame");
        /* Wir setzen die Breite und die Höhe
           unseres Fensters auf 200 Pixel */
        meinFrame.setSize(200,200);
        // Wir lassen unseren Frame anzeigen
        meinFrame.setVisible(true);
    }
}
