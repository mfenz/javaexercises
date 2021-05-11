package at.cb.steuerrechner.model;

public class Einfamilienhaus implements Besteuerbar, Belastbar {
    // Konstanten
    public static final double VERMOEGENSSTEUERSATZ = 0.015; // 1.5%
    public static final double BELEIHUNGSFAKTOR = 0.8; // 80%

    // Instanzvariable
    private double verkehrswert;

    public Einfamilienhaus(double verkehrswert){
        this.verkehrswert = verkehrswert;
    }

    @Override
    public double berechneBeleihungswert() {
        return verkehrswert * BELEIHUNGSFAKTOR;
    }

    @Override
    public double berechneSteuerBetrag() {
        return verkehrswert * VERMOEGENSSTEUERSATZ;
    }
}
