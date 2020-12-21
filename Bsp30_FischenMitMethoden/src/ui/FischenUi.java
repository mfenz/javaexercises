package ui;

import bl.FischenBl;
import bl.FishPosition;

public class FischenUi {
    private FischenBl bl;

    public FischenUi(FischenBl bl){
        this.bl = bl;
    }

    public void play(){
        showPond(true);
    }

    public void showPond(boolean showFish){
        // Header
        System.out.print("  |");
        for(char i = 'A'; i < 'A' + bl.getPondWidth(); ++i){
            System.out.print("" + i + "|");
        }

        // get fish position
        FishPosition fishPosition = bl.getFishPosition();

        for(int i = 0; i < bl.getPondHeight(); ++i){
            System.out.println();
            System.out.print(i + 1 + " |");
            for(int j = 0; j < bl.getPondWidth(); ++j){
                if(showFish && fishPosition.getRow() == i && fishPosition.getCol() == j){
                    System.out.print("F|");
                } else {
                    System.out.print(" |");
                }
            }
        }
    }
}
