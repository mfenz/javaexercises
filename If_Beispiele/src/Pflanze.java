public class Pflanze {
    private int wasserLevel;
    public void giessen(){
        // nur giessen wenn
        // wasserLevel kleiner 100
        if(wasserLevel < 100){
            wasserLevel++;
        }
    }
}
