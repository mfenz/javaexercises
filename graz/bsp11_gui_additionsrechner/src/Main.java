import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Fenster erzeugen
        AdditionsrechnerGUI gui = new AdditionsrechnerGUI();

        // Fenster sichtbar setzen
        gui.setVisible(true);

        // Das Programm soll beendet werden wenn das Fenster geschlossen wird
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Fenster mittig öffnen
        gui.setLocationRelativeTo(null);
    }
}