package at.cb.malerei.model;

public class Rechteck {
    // Instanzvariablen
    // Angaben in m
    private float hoehe;
    private float breite;

    public Rechteck(float hoehe, float breite){
        this.hoehe = hoehe;
        this.breite = breite;
    }

    public float getFlaeche(){
        return hoehe * breite;
    }
}
