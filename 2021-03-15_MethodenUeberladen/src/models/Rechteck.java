package models;

public class Rechteck {
    // Instanzvariablen
    private float a;
    private float b;

    public Rechteck(float a, float b){
        this.a = a;
        this.b = b;
    }

    public float getFlaeche(){
        return a * b;
    }

    public float getUmfang(){
        return 2*a + 2*b;
    }
}
