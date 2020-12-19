package gui;

import bl.TicTacToeBl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGui extends JFrame {
    private TicTacToeBl bl;

    private JPanel jpMain = new JPanel();
    private JPanel jpUser = new JPanel();
    private JPanel jpBoard = new JPanel();
    private JButton[][] btCells = new JButton[3][3];

    private JLabel lbUserInfo;
    private JLabel lbUserName;


    public TicTacToeGui(TicTacToeBl bl) throws HeadlessException {
        this.bl = bl;
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jpMain.setLayout(new BorderLayout());
        jpUser.setLayout(new GridLayout(1, 2));
        jpBoard.setLayout(new GridLayout(3,3));

        TicTacToeCellActionListener ticTacToeCellActionListener = new TicTacToeCellActionListener();
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                JButton btCell = new JButton();
                // i: row, j: column
                btCell.setName(i+","+j);
                btCell.addActionListener(ticTacToeCellActionListener);
                jpBoard.add(btCell);
                btCells[i][j] = btCell;
            }
        }

        lbUserInfo = new JLabel("Aktueller Spieler:");
        lbUserName = new JLabel("");
        jpUser.add(lbUserInfo);
        jpUser.add(lbUserName);

        jpMain.add(jpUser, BorderLayout.NORTH);
        jpMain.add(jpBoard, BorderLayout.CENTER);

        this.getContentPane().add(jpMain);
        pack();
        updateUI();
    }

    private void updateUI(){
        for(int i = 0; i < btCells.length; ++i){
            for(int j = 0; j < btCells[i].length; ++j){
                JButton cell = btCells[i][j];
                String userName = getUserName(bl.getBoard(i, j));
                cell.setText(userName);
            }
        }

        lbUserName.setText(getUserName(bl.getCurrentPlayer()));
    }

    private String getUserName(int userNumber){
        switch (userNumber){
            case 0: return "";
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
            String[] split = name.split(",");
            int row = Integer.parseInt(split[0]);
            int col = Integer.parseInt(split[1]);
            bl.move(row, col);
            updateUI();
        }
    }
}
