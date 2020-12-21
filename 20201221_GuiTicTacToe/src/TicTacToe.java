import bl.TicTacToeBl;
import gui.TicTacToeGui;

public class TicTacToe {
    public static void main(String[] args) {
        TicTacToeBl bl = new TicTacToeBl(3);
        TicTacToeGui gui = new TicTacToeGui(bl);
        gui.setVisible(true);
    }
}
