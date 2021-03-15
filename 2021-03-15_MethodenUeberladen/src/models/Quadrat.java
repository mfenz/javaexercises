package models;

public class Quadrat {
    private float kantenlaenge;

    public Quadrat(float kantenlaenge){
        this.kantenlaenge = kantenlaenge;
    }

    public float getFlaeche(){
        return (float) Math.pow(kantenlaenge, 2);
    }

    public float getUmfang(){
        return 4 * kantenlaenge;
    }
}
