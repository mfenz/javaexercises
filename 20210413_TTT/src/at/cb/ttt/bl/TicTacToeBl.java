package at.cb.ttt.bl;

import at.cb.ttt.db.DatabaseManager;
import at.cb.ttt.model.Player;

import java.util.Scanner;

public class TicTacToeBl {

    private Scanner scanner = new Scanner(System.in);

    // wie x, y Koordinaten
    // 3 Zeilen, 3 Spalten
    private Player[][] board = new Player[3][3];

    // Aktiver Spieler
    private Player currentPlayer;

    // User hinzufügen
    private void addPlayers(){
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
        addPlayers();
    }

}
