package at.cb.ttt;

public class TicTacToe {

    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';

    public String play(int x, int y){
        checkAxis(x);
        checkAxis(y);
        setBoard(x, y);
        printBoard();

        if(checkWinnerHorizontal() || checkWinnerVertical() || checkWinnerDiagonal()){
            return "Winner " + currentPlayer;
        }
        if(checkDraw()){
            return "Draw";
        }

        nextPlayer();

        return "No winner";
    }

    private boolean checkWinnerHorizontal(){
        // Check horizontale
        for(int zeile = 0; zeile < 3; zeile++){
            boolean same = true;
            for(int spalte = 0; spalte < 3; spalte++){
                if (board[0][zeile] == 0 || board[spalte][zeile] != board[0][zeile] ) {
                    same = false;
                }
            }
            if(same){
                //System.out.println("Horizontal true!");
                return true;
            }
        }
        return false;
    }

    private boolean checkWinnerVertical(){
        // check vertikale
        for(int spalte = 0; spalte < 3; spalte++){
            boolean same = true;
            for(int zeile = 0; zeile < 3; zeile++){
                if(board[spalte][0] == 0 || board[spalte][zeile] != board[spalte][0]){
                    same = false;
                }
            }
            if(same){
                //System.out.println("Vertikal true!");
                return true;
            }
        }
        return false;
    }

    private boolean checkWinnerDiagonal(){
        if(board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            return true;
        }
        if(board[2][0] != 0 && board[2][0] == board[1][1] && board[1][1] == board[0][2]){
            return true;
        }
        return false;
    }

    private boolean checkDraw(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    private void checkAxis(int axis){
        if(axis < 1 || axis > 3){
            throw new RuntimeException();
        }
    }

    private void setBoard(int x, int y){
        if(board[x-1][y-1] == 0){
            board[x-1][y-1] = currentPlayer;
        } else {
            throw new RuntimeException("Feld schon besetzt");
        }
    }

    private void nextPlayer(){
        if(currentPlayer == 'X'){
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    public char getCurrentPlayer(){
        return currentPlayer;
    }

    public void printBoard(){
        for(int zeile = 0; zeile < 3; zeile++){
            for(int spalte = 0; spalte < 3; spalte++){
                System.out.print(board[spalte][zeile] + " ");
            }
            System.out.println();
        }
        System.out.println("---");
    }

}
