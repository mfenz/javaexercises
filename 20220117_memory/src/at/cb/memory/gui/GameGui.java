package at.cb.memory.gui;

import at.cb.memory.bl.GameBl;
import at.cb.memory.model.BoardPosition;
import at.cb.memory.model.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class GameGui extends JFrame {
    private GameBl bl;

    private JMenuBar menuBar;
    private JMenu meGame;
    private JMenuItem miNewGame, miExit;

    private JPanel paScore;
    private JPanel paBoard;

    private JLabel lbScoreA, lbScoreB, lbCurrentPlayer;
    private JButton[][] board;

    public GameGui(GameBl bl){
        this.bl = bl;
        initView();

        setSize(400, 400);
    }

    private void initView(){
        this.setLayout(new BorderLayout());

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        meGame = new JMenu("Game");
        menuBar.add(meGame);

        miNewGame = new JMenuItem("New game");
        miNewGame.addActionListener(e -> onRestart());
        meGame.add(miNewGame);

        miExit = new JMenuItem("Exit");
        miExit.addActionListener(e -> onExit());
        meGame.add(miExit);

        // Score Panel
        paScore = new JPanel(new GridLayout(1, 3));
        this.add(paScore, BorderLayout.NORTH);

        lbScoreA = new JLabel("A: 0", SwingConstants.CENTER);
        lbScoreA.setFont(new Font("Arial", Font.BOLD, 18));
        paScore.add(lbScoreA);

        lbCurrentPlayer = new JLabel("<-", SwingConstants.CENTER);
        lbCurrentPlayer.setFont(new Font("Arial", Font.BOLD, 18));
        paScore.add(lbCurrentPlayer);

        lbScoreB = new JLabel("B: 0", SwingConstants.CENTER);
        lbScoreB.setFont(new Font("Arial", Font.BOLD, 18));
        paScore.add(lbScoreB);

        // Board Panel
        paBoard = new JPanel(new GridLayout(GameBl.BOARD_HEIGHT, GameBl.BOARD_WIDTH));
        this.add(paBoard, BorderLayout.CENTER);

        initBoard();
    }

    private void initBoard(){
        paBoard.removeAll();
        paBoard.invalidate();

        board = new JButton[GameBl.BOARD_HEIGHT][GameBl.BOARD_WIDTH];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                JButton button = new JButton();
                button.setSize(100, 100);
                button.setName(i + "," +j);
                button.addActionListener(boardClickActionListener);

                board[i][j] = button;
                paBoard.add(button);
            }
        }

        paBoard.revalidate();
    }

    private ActionListener boardClickActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String name = button.getName();
            String[] split = name.split(",");
            int row = Integer.parseInt(split[0]);
            int col = Integer.parseInt(split[1]);

            // Feld (Karte) aufdecken
            showCard(row, col);

            // vor dem Play aufrufen weil es im play zurückgesetzt wird
            Optional<BoardPosition> previouslySelectedPosition = bl.getPreviouslySelectedPosition();

            GameBl.PLAY_RESULT playResult = bl.play(row, col);
            switch (playResult){
                case PAIR_FOUND: {
                    disableCard(row, col);
                    if(previouslySelectedPosition.isPresent()){
                        disableCard(previouslySelectedPosition.get().getRow(), previouslySelectedPosition.get().getCol());
                    }
                    break;
                }
                case CONTINUE: {
                    // Feld aufdecken und aufgedeckt lassen
                    break;
                }
                case PAIR_NOT_FOUND: {
                    // Karten zudecken

                    if(previouslySelectedPosition.isPresent()){
                        hideCard(previouslySelectedPosition.get().getRow(), previouslySelectedPosition.get().getCol());
                    }
                    hideCard(row, col);
                    break;
                }
            }
            updatePlayers();
            checkWinner();
        }
    };

    private void showCard(int row, int col){
        JButton button = board[row][col];
        String fileName = bl.getBoardImageFileName(row, col);
        try {
            Image original = ImageIO.read(new File(fileName));
            Image resized = original.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(resized));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void hideCard(int row, int col){
        JButton button = board[row][col];

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setIcon(null);
            }
        });
        timer.setRepeats(false);
        timer.start();

    }

    private void disableCard(int row, int col){
        //board[row][col].setEnabled(false);
        JButton button = board[row][col];
        ActionListener[] actionListeners = button.getActionListeners();
        for(ActionListener al : actionListeners){
            button.removeActionListener(al);
        }
    }

    private void updatePlayers(){
        // wer ist gerade drann?
        int currentPlayerIndex = bl.getCurrentPlayerIndex();
        if(currentPlayerIndex == 0){
            lbCurrentPlayer.setText("<-");
        } else {
            lbCurrentPlayer.setText("->");
        }

        // Punkte update
        Player player1 = bl.getPlayer1();
        Player player2 = bl.getPlayer2();

        lbScoreA.setText(player1.getName() + ": " + player1.getPoints());
        lbScoreB.setText(player2.getName() + ": " + player2.getPoints());
    }

    private void onExit(){
        System.exit(0);
    }

    private void onRestart(){
        bl = new GameBl();

        // Board reset
        initBoard();
    }

    private void checkWinner(){
        if(bl.checkWinner()){
            // Gewinner herausfinden ...
            Player p1 = bl.getPlayer1();
            Player p2 = bl.getPlayer2();

            if(p1.getPoints() == p2.getPoints()){
                JOptionPane.showMessageDialog(this, "Draw!", "Game has ended", JOptionPane.INFORMATION_MESSAGE);
            } else if(p1.getPoints() < p2.getPoints()){
                JOptionPane.showMessageDialog(this, "Player B wins!", "Game has ended", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Player A wins!", "Game has ended", JOptionPane.INFORMATION_MESSAGE);
            }

            onRestart();
        }
    }

}
