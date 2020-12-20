package bl;

// Business logic
public class TicTacToeBl {
    // Instanzvariable
    // Spielfeld als zweidimensionales Array
    // 0: nicht belegt
    // 1: Spieler 1
    // 2: Spieler 2
    private int[][] board;

    // 1: Spieler 1, 2: Spieler 2
    private int currentPlayer = 1;

    // Winner: -1: draw, 0 no winner, 1: player 1, 2: player 2
    private int winner = 0;

    public TicTacToeBl(int boardSize) {
        board = new int[boardSize][boardSize];
    }

    /**
     * Ein Spielzug
     * @param row geklickte Reihe
     * @param col geklickte Spalte
     */
    public void move(int row, int col){
        // Prüfen ob dieses Feld schon geklickt wurde
        if(board[row][col] != 0){
            // wenn das Feld bereits belegt ist, abbrechen.
            return;
        }
        // aktuellen Spieler auf die Spielfeld-Position setzen
        board[row][col] = currentPlayer;
        winner = checkWinner();
        // currentPlayer ändern
        nextPlayer();
    }

    /**
     * Wechselt nach jedem Spielzeug den Spieler
     */
    private void nextPlayer(){
        switch (currentPlayer){
            case 1: currentPlayer = 2; break;
            case 2: currentPlayer = 1; break;
        }
    }

    /**
     * Prüft ob das Spiel gewonnen wurde.
     * @return 0 fall niemand gewonnen hat oder die ID des Gewinners
     */
    public int checkWinner(){
        // alle Zeilen prüfen
        for(int row = 0; row < board.length; ++row){
            int player = board[row][0];
            for(int col = 0; col < board[row].length; ++col){
                if(player != board[row][col]){
                    player = 0;
                    break;
                }
            }
            if(player > 0){
                return player;
            }
        }

        // alle Spalten prüfen
        for(int col = 0; col < board[0].length; ++col){
            int player = board[0][col];
            for(int row = 0; row < board.length; ++row){
                if(player != board[row][col]){
                    player = 0;
                    break;
                }
            }
            if(player > 0){
                return player;
            }
        }

        // Diagonale von links oben nach rechts unten
        int player = board[0][0];
        for(int row = 0; row < board.length; ++row){
            // Diagonale: row = column
            if(player != board[row][row]){
                player = 0;
                break;
            }
        }
        if(player > 0){
            return player;
        }
        // Diagonale von rechts oben nach links unten
        int col = board.length - 1;
        player = board[0][col];
        for(int row = 0; row < board.length; ++row){
            if(player != board[row][col]){
                player = 0;
                break;
            }
            col--;
        }
        if(player > 0){
            return player;
        }
        // unentschieden? Wenn alle Felder belegt sind und niemand gewonnen hat
        boolean emptyField = false;
        for(int row = 0; row < board.length; ++row){
            for(col = 0; col < board[row].length; ++col){
                if(board[row][col] == 0){
                    emptyField = true;
                }
            }
        }
        if(!emptyField){
            return -1;
        }

        return 0;
    }

    public int getBoardPosition(int row, int col){
        return board[row][col];
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int getBoardSize(){
        return board.length;
    }

    public int getWinner() {
        return winner;
    }
}
