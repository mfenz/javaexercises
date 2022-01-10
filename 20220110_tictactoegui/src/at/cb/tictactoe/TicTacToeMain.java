package at.cb.tictactoe;

import javax.swing.*;

public class TicTacToeMain {
    public static void main(String[] args) {
        TicTacToeBl bl = new TicTacToeBl();
        TicTacToeGui gui = new TicTacToeGui(bl);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
    }
}
