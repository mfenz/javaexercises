package bl;

// Business logic
public class TicTacToeBl {
    // Instanzvariable
    // Spielfeld als zweidimensionales Array
    // null: nicht gesetzt
    // 1: Spieler 1
    // 2: Spieler 2
    private int[][] board = new int[3][3];

    // 1: Spieler 1, 2: Spieler 2
    private int currentPlayer = 1;

    public TicTacToeBl() {
    }

    public void move(int row, int col){
        // Prüfen ob dieses Feld schon geklickt wurde
        if(board[row][col] != 0){
            return;
        }
        board[row][col] = currentPlayer;
        // currentPlayer ändern
        nextPlayer();
    }

    private void nextPlayer(){
        switch (currentPlayer){
            case 1: currentPlayer = 2; break;
            case 2: currentPlayer = 1; break;
        }
    }

    public int getBoard(int row, int col){
        return board[row][col];
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }
}
