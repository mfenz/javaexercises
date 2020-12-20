import bl.TicTacToeBl;
import gui.TicTacToeGui;

public class TicTacToe {
    public static void main(String[] args) {
        // initialisiert Spielfeld in Business Logic mit 3 Zeilen/Spalten
        TicTacToeBl bl = new TicTacToeBl(3);
        // Erstellt das GUI Objekt
        // Bl als Übergabeparamter
        TicTacToeGui gui = new TicTacToeGui(bl);
        // Fenster sichtbar setzen
        gui.setVisible(true);
    }
}
