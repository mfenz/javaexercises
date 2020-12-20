package gui;

import bl.TicTacToeBl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGui extends JFrame {
    // Business Logic hält Daten zum aktuellen Spiel
    private TicTacToeBl bl;

    // Dieses JPanel beinhaltet alles
    private JPanel jpMain = new JPanel();
    // JPanel beinhaltet aktuelle Spieler-Info
    private JPanel jpUser = new JPanel();
    // JPanel mit dem Spielfeld (Buttons kommen hier rein)
    private JPanel jpBoard = new JPanel();
    // Zweidimensionales-Array in dem eine Referenz zu den Spielfeld-Buttons gespeichert wird
    private JButton[][] btCells;

    // "Player"
    private JLabel lbUserInfo;
    // X oder O
    private JLabel lbUserName;

    public TicTacToeGui(TicTacToeBl bl) throws HeadlessException {
        this.bl = bl;
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jpMain.setLayout(new BorderLayout());
        jpUser.setLayout(new GridLayout(1, 2));
        // Holt sich mit bl.getBoardSize() die Größe des Spielfeldes
        jpBoard.setLayout(new GridLayout(bl.getBoardSize(),bl.getBoardSize()));

        // Alle Spielfeld-Buttons haben den gleichen ActionListener
        TicTacToeCellActionListener ticTacToeCellActionListener = new TicTacToeCellActionListener();
        // Initialisiert das Array das Referenzen zu den Spielfeld-Buttons hält
        // wird benötigt um danach den Text auf den Buttons verändern zu können
        btCells = new JButton[bl.getBoardSize()][bl.getBoardSize()];
        // Erstellt in einer geschachtelten Schleife die Buttons für das Spielfeld
        for(int i = 0; i < bl.getBoardSize(); ++i){
            for(int j = 0; j < bl.getBoardSize(); ++j){
                // Neuen Button erstellen
                JButton btCell = new JButton();
                // name setzen damit wir beim ActionListener wissen welcher Button gedrückt wurde
                // i: row, j: column
                btCell.setName(i+","+j);
                // alle Buttons bekommen den gleichen ActionListener
                btCell.addActionListener(ticTacToeCellActionListener);
                // Button in die GUI einfügen
                jpBoard.add(btCell);
                // Button-Referenz im Array speichern
                btCells[i][j] = btCell;
            }
        }

        lbUserInfo = new JLabel("Player:");
        lbUserName = new JLabel("");
        jpUser.add(lbUserInfo);
        jpUser.add(lbUserName);

        // BorderLayout
        jpMain.add(jpUser, BorderLayout.NORTH);
        jpMain.add(jpBoard, BorderLayout.CENTER);

        this.getContentPane().add(jpMain);
        pack();
        // Text auf GUI-Elementen "initialisieren"
        updateUI();
    }

    /**
     * Aktualisiert nach einem Spielzug den Text auf alen GUI Elementen
     */
    private void updateUI(){
        for(int i = 0; i < btCells.length; ++i){
            for(int j = 0; j < btCells[i].length; ++j){
                JButton cell = btCells[i][j];
                String userName = getUserName(bl.getBoardPosition(i, j));
                cell.setText(userName);
            }
        }
        lbUserName.setText(getUserName(bl.getCurrentPlayer()));
    }

    /**
     * Wandelt die "UserID" in einen Namen um
     * @param userNumber
     * @return -1 für unentschieden, 0: leerer String, 1: X, 2: O
     */
    private String getUserName(int userNumber){
        switch (userNumber){
            case -1: return "draw";
            case 0: return "";
            case 1: return "X";
            case 2: return "O";
            default: return "undefined";
        }
    }

    private final class TicTacToeCellActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Den gedrückten Button holen
            // (JButton) ist ein Cast
            JButton btCell = (JButton)e.getSource();
            // "name" Attribut rausholen
            String name = btCell.getName();
            // "name" Attribut aufspalten
            String[] split = name.split(",");
            int row = Integer.parseInt(split[0]);
            int col = Integer.parseInt(split[1]);
            // Spielzug durchführen
            bl.move(row, col);
            // User interface update
            updateUI();
            // prüfen ob jemand gewonnen hat
            if(bl.getWinner() != 0){
                // falls jemand gewonnen hat (oder unentschieden), mit einem Dialog ausgeben
                JOptionPane.showMessageDialog(TicTacToeGui.this,
                        "And the winner is ... " + getUserName(bl.getWinner()));
            }
        }
    }
}
