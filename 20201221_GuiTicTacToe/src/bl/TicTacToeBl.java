package bl;
// business logic
public class TicTacToeBl {

    // 0: nicht gesetzt, 1: Spieler 1, 2: Spieler 2
    private int[][] board;

    // 1: Spieler 1, 2: Spieler 2
    private int currentPlayer = 1;

    public TicTacToeBl(int boardSize){
        board = new int[boardSize][boardSize];
    }

    /**
     * Ein Spielzug
     * @param row
     * @param col
     */
    public void move(int row, int col){
        // Spielzug durchführen

        checkWinner();
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


}
