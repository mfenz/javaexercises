package at.cb.memory.bl;

import at.cb.memory.model.BoardPosition;
import at.cb.memory.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class GameBl {
    public static final int BOARD_WIDTH = 4;
    public static final int BOARD_HEIGHT = 4;

    private Player[] players = new Player[2];
    private int currentPlayerIndex;

    private int[][] board = new int[BOARD_HEIGHT][BOARD_WIDTH];

    private Optional<BoardPosition> previouslySelectedPosition = Optional.empty();

    public enum PLAY_RESULT {
        PAIR_FOUND, // 2 richtige
        CONTINUE, // weiter Spielzug notwendig
        PAIR_NOT_FOUND
    }

    public GameBl(){
        initPlayers();
        initBoard();
    }

    private void initPlayers(){
        players[0] = new Player("A");
        players[1] = new Player("B");
        currentPlayerIndex = 0;
    }

    /**
     * Spielkarten auf das Feld verteilen
     */
    private void initBoard(){
        // Kartenstapel befüllen
        List<Integer> cards = new ArrayList<>();
        for(int card = 1; card <= (BOARD_WIDTH * BOARD_HEIGHT) / 2; card++){
            cards.add(card);
            cards.add(card);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                int cardIndex = ThreadLocalRandom.current().nextInt(cards.size());
                // Karte auf das Spielfeld legen
                board[i][j] = cards.get(cardIndex);
                System.out.println(board[i][j]);
                // Karte aus dem Stpel entfernen
                cards.remove(cardIndex);
            }
        }

    }



    public PLAY_RESULT play(int row, int column){

        /**
         * 2 Richtige
         * 1 fehlt noch
         * 2 falsche
         */

        if(previouslySelectedPosition.isEmpty()){
            previouslySelectedPosition = Optional.of(new BoardPosition(row, column));
            return PLAY_RESULT.CONTINUE;
        } else {
            // check if player selected two same images
            int imgSelected1 = board[ previouslySelectedPosition.get().getRow() ][ previouslySelectedPosition.get().getCol() ];
            int imgSelected2 = board[row][column];

            previouslySelectedPosition = Optional.empty();
            if(imgSelected1 == imgSelected2){
                getCurrentPlayer().setPoints(getCurrentPlayer().getPoints() + 1);
                return PLAY_RESULT.PAIR_FOUND;
            } else {
                nextPlayer();
                return PLAY_RESULT.PAIR_NOT_FOUND;
            }


        }
    }

    public boolean checkWinner(){
        if(getPlayer1().getPoints() + getPlayer2().getPoints() == (BOARD_HEIGHT * BOARD_WIDTH) / 2){
            return true;
        }
        return false;
    }

    private void nextPlayer(){
        if(currentPlayerIndex == 0){
            currentPlayerIndex = 1;
        } else {
            currentPlayerIndex = 0;
        }
    }

    public int getCurrentPlayerIndex(){
        return currentPlayerIndex;
    }

    public Player getCurrentPlayer(){
        return players[getCurrentPlayerIndex()];
    }

    public String getBoardImageFileName(int row, int col){
        return String.format("f%d.jpg", board[row][col]);
    }

    public Player getPlayer1(){
        return players[0];
    }

    public Player getPlayer2(){
        return players[1];
    }

    public Optional<BoardPosition> getPreviouslySelectedPosition(){
        return previouslySelectedPosition;
    }
}
