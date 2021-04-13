package at.cb.ttt.bl;

import at.cb.ttt.model.Player;

import java.util.Scanner;

public class TicTacToeBl {

    private Scanner scanner = new Scanner(System.in);

    // wie x, y Koordinaten
    // 3 Zeilen, 3 Spalten
    private Player[][] board = new Player[3][3];

    // Aktiver Spieler, 0 oder 1
    // Instanzvariable default 0
    private int currentPlayer;

    // Array mit Spielern
    private Player[] players = new Player[2];

    // User hinzufügen
    private void addPlayers(){
        // Spieler 1 erstellen
        System.out.println("Spieler 1:");
        players[0] = createPlayer();
        // Spieler 2 erstellen
        System.out.println("Spieler 2:");
        players[1] = createPlayer();
    }

    // erstellt einen Player
    private Player createPlayer(){
        System.out.println("Name eingeben:");
        String name = scanner.nextLine();
        char symbol = ' ';
        // solange das Symbol leer ist
        while (symbol == ' '){
            System.out.println("Symbol eingeben:");
            // Gesamte Zeile einlesen
            String symbolStr = scanner.nextLine();
            // Prüfen ob nur ein Zeichen eingegeben wurde
            if(symbolStr.length() == 1){
                // Erstes Zeichen holen
                symbol = symbolStr.charAt(0);
            } else {
                System.out.println("Symbol: ungültige Eingabe!");
            }
        }
        // Player Objekt erstellen
        Player player = new Player(name, symbol);
        return player;
    }

    // Spiel starten
    public void play(){
        // Am Anfang Spieler hinzufügen
        addPlayers();
        board[1][1] = players[0];
        board[0][2] = players[1];
        printBoard();
    }

    public void printBoard(){
        for(int zeile = 0; zeile < board.length; zeile++){
            for(int spalte = 0; spalte < board[zeile].length; spalte++){
                if(board[zeile][spalte] == null){
                    // wenn noch nichts ausgewählt wurde
                    System.out.print("-");
                } else {
                    // Player Symbol ausgeben
                    System.out.print(board[zeile][spalte].getSymbol());
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
