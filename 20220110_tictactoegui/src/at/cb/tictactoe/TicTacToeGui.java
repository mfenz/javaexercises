package at.cb.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGui extends JFrame {
    private TicTacToeBl bl;

    private JMenuBar jMenuBar = new JMenuBar();
    private JMenu meGame = new JMenu("Game");

    private JLabel lbCurrentPlayer;

    private JPanel paBoard;
    private JButton[][] buttons;

    public TicTacToeGui(TicTacToeBl bl){
        super("Tic Tac Toe");
        this.bl = bl;

        this.setJMenuBar(jMenuBar);
        jMenuBar.add(meGame);

        // Layout für das JFrame
        this.setLayout(new BorderLayout());

        lbCurrentPlayer = new JLabel("Current player: X");
        this.add(lbCurrentPlayer, BorderLayout.NORTH);

        paBoard = new JPanel(new GridLayout(3, 3));
        this.add(paBoard, BorderLayout.CENTER);

        buttons = new JButton[3][3];
        for(int i = 0; i < buttons.length; i++){
            for(int j = 0; j < buttons[i].length; j++){
                JButton bt = new JButton("");
                bt.setName(i+","+j);
                // Button ins Array hinzufügen
                buttons[i][j] = bt;
                // Button ins Panel hinzufügen
                paBoard.add(bt);

                bt.addActionListener(e -> {
                    JButton button = (JButton) e.getSource();
                    String[] split = button.getName().split(",");
                    int row = Integer.parseInt(split[0]);
                    int column = Integer.parseInt(split[1]);
                    onGameButtonClicked(row, column);
                });
            }
        }


        setSize(300, 300);
    }

    private void onGameButtonClicked(int row, int column){
        System.out.printf("clicked: row: %d, column: %d %n", row, column);
    }
}
