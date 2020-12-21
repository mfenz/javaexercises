package gui;

import javax.swing.*;
import java.awt.*;

public class TicTacToeGui extends JFrame {

    // Beinhaltet alle Elemente
    private JPanel jpMain = new JPanel();
    // User information
    private JPanel jpUser = new JPanel();
    private JPanel jpBoard = new JPanel();

    private JLabel lbUserInfo;
    // X oder O
    private JLabel lbUserName;

    public TicTacToeGui(){
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jpMain.setLayout(new BorderLayout());
        jpUser.setLayout(new GridLayout(1, 2));
        jpBoard.setLayout(new GridLayout());

    }
}
