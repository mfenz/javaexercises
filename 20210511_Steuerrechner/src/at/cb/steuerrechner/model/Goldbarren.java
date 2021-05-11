package at.cb.steuerrechner.model;

public class Goldbarren implements Besteuerbar, Belastbar {
    public static final double GRAMM_PREIS = 48.58;
    public static final double VERMOEGENSSTEUERSATZ = 0.05; // 5%
    public static final double BELEIHUNGSFAKTOR = 0.5; // 50%

    private double gramm;

    public Goldbarren(double gramm){
        this.gramm = gramm;
    }

    public double getWert(){
        return gramm * GRAMM_PREIS;
    }

    @Override
    public double berechneBeleihungswert() {
        return getWert() * BELEIHUNGSFAKTOR;
    }

    @Override
    public double berechneSteuerBetrag() {
        return getWert() * VERMOEGENSSTEUERSATZ;
    }
}
