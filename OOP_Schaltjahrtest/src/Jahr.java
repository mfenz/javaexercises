public class Jahr {
    // Instanzvariable (Attribut)
    // Eigenschaft (Zustand)
    private int jahr;
    // Konstruktor
    public Jahr(int jahr){
        this.jahr = jahr;
    }

    // Methode isSchaltjahr()
    public boolean isSchaltjahr(){
        // 6 / 4 = 1
        // 6 % 4 = 2   % --> Modulo
        if(jahr % 4 == 0 && jahr % 100 != 0){
            return true;
        }
        if(jahr % 100 == 0 && jahr % 400 != 0){
            return false;
        }
        if(jahr % 400 == 0){
            return true;
        }
        return false;
    }

    public int getJahr(){
        return jahr;
    }
}
