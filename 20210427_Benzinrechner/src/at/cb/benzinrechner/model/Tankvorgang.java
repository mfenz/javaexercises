package at.cb.benzinrechner.model;

public class Tankvorgang {
    private float liter;
    private float distanzKm;
    private float betrag;

    public Tankvorgang(float liter, float distanzKm, float betrag){
        this.liter = liter;
        this.distanzKm = distanzKm;
        this.betrag = betrag;
    }

    public float getVerbrauchLiterPro100km(){
        return (liter / distanzKm) * 100;
    }

    public float getKostenProKm(){
        return betrag / distanzKm;
    }

    public float getLiter() {
        return liter;
    }

    public void setLiter(float liter) {
        this.liter = liter;
    }

    public float getDistanzKm() {
        return distanzKm;
    }

    public void setDistanzKm(float distanzKm) {
        this.distanzKm = distanzKm;
    }

    public float getBetrag() {
        return betrag;
    }

    public void setBetrag(float betrag) {
        this.betrag = betrag;
    }
}
