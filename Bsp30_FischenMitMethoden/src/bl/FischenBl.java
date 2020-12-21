package bl;

import java.util.Random;

public class FischenBl {
    private int [][] pond;

    public FischenBl(int width, int height){
        // Teich initialisieren
        pond = new int[height][width];

        initFishPosition();
    }

    private void initFishPosition(){
        pond[randomNumber(0, pond.length - 1)]
                [randomNumber(0, pond[0].length - 1)] = 1;
    }

    public void move(int row, int col){

    }

    private void swim(){
        // wo ist der Fisch derzeit?
        FishPosition fishPosition = getFishPosition();
        
    }

    public int getPondWidth(){
        return pond[0].length;
    }

    public int getPondHeight(){
        return pond.length;
    }

    public FishPosition getFishPosition(){
        // find fish in array
        for(int i = 0; i < pond.length; ++i){
            for(int j = 0; j < pond[i].length; ++j){
                if(pond[i][j] != 0){
                    return new FishPosition(i, j);
                }
            }
        }
        // no fish fond...
        return new FishPosition(-1, -1);
    }

    private int randomNumber(int low, int high){
        Random r = new Random();
        int result = r.nextInt(high-low) + low;
        return result;
    }
}
