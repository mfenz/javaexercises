package gui;

import bl.TicTacToeBl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private JButton[][] btCells;

    public TicTacToeGui(TicTacToeBl bl){
        this.bl = bl;
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jpMain.setLayout(new BorderLayout());
        jpUser.setLayout(new GridLayout(1, 2));
        jpBoard.setLayout(new GridLayout(bl.getBoardSize(), bl.getBoardSize()));

        // User Info
        lbUserInfo = new JLabel("Player:");
        lbUserName = new JLabel("");
        jpUser.add(lbUserInfo);
        jpUser.add(lbUserName);
        jpMain.add(jpUser, BorderLayout.PAGE_START);

        // Spielfeld
        btCells = new JButton[bl.getBoardSize()][bl.getBoardSize()];
        TicTacToeCellActionListener ticTacToeCellActionListener = new TicTacToeCellActionListener();
        for(int i = 0; i < bl.getBoardSize(); ++i){
            for(int j = 0; j < bl.getBoardSize(); ++j){
                // Neuen Button erstellen
                JButton btCell = new JButton();
                btCell.setName(i+","+j);
                btCell.addActionListener(ticTacToeCellActionListener);
                jpBoard.add(btCell);
                // Button ins Array einfügen (für UI updates)
                btCells[i][j] = btCell;
            }
        }
        jpMain.add(jpBoard, BorderLayout.CENTER);
        this.getContentPane().add(jpMain);
        pack();

        updateUi();
    }

    private void updateUi(){
        // Buttons
        for(int i = 0; i < btCells.length; ++i){
            for(int j = 0; j < btCells[i].length; ++j){
                JButton btCell = btCells[i][j];
                int field = bl.getBoardPosition(i, j);
                String cellText = getUserName(field);
                btCell.setText(cellText);
            }
        }

        // Current Player
        int currentPlayer = bl.getCurrentPlayer();
        String userName = getUserName(currentPlayer);
        lbUserName.setText(userName);
    }

    private String getUserName(int userNumber){
        switch (userNumber){
            case 1: return "X";
            case 2: return "O";
            default: return "undefined";
        }
    }

    private final class TicTacToeCellActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btCell = (JButton)e.getSource();
            String name = btCell.getName();
            String[] nameSplit = name.split(",");
            int row = Integer.parseInt(nameSplit[0]);
            int col = Integer.parseInt(nameSplit[1]);
            // Spielzug durchführen
            bl.move(row, col);
            updateUi();
        }
    }
}
