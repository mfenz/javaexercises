package gui;

import bl.TicTacToeBl;

import javax.swing.*;
import java.awt.*;

public class TicTacToeGui extends JFrame {

    private TicTacToeBl bl;

    // Beinhaltet alle Elemente
    private JPanel jpMain = new JPanel();
    // User information
    private JPanel jpUser = new JPanel();
    private JPanel jpBoard = new JPanel();

    private JLabel lbUserInfo;
    // X oder O
    private JLabel lbUserName;

    public TicTacToeGui(TicTacToeBl bl){
        this.bl = bl;
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jpMain.setLayout(new BorderLayout());
        jpUser.setLayout(new GridLayout(1, 2));
        jpBoard.setLayout(new GridLayout(bl.getBoardSize(), bl.getBoardSize()));

        lbUserInfo = new JLabel("Player:");
        lbUserName = new JLabel("");
        jpUser.add(lbUserInfo);
        jpUser.add(lbUserName);
        jpMain.add(jpUser, BorderLayout.NORTH);

        this.getContentPane().add(jpMain);
        pack();
    }
}
