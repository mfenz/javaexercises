package bl;
// business logic
public class TicTacToeBl {

    // 0: nicht gesetzt, 1: Spieler 1, 2: Spieler 2
    private int[][] board;

    // 1: Spieler 1, 2: Spieler 2
    private int currentPlayer = 1;

    // -1: unentschieden, 0: noch niemand, 1: Spieler 1, 2: Spieler 2
    private int winner = 0;

    public TicTacToeBl(int boardSize){
        board = new int[boardSize][boardSize];
    }

    /**
     * Ein Spielzug
     * @param row
     * @param col
     */
    public void move(int row, int col){
        if(board[row][col] != 0){
            // Feld ist bereits belegt!
            return;
        }
        // Spielfeld setzen
        board[row][col] = currentPlayer;
        // Gewinner ermitteln
        winner = checkWinner();
        // currentPlayer ändern
        nextPlayer();
    }

    private int checkWinner(){
        return 0;
    }

    private void nextPlayer(){
        switch (currentPlayer){
            case 1: currentPlayer = 2; break;
            case 2: currentPlayer = 1; break;
        }
    }

    public int getCurrentPlayer(){
        return currentPlayer;
    }

    public int getBoardSize(){
        return board.length;
    }


}
