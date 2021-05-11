package at.cb.steuerrechner.model;

import java.time.LocalDate;

public class Auto implements Besteuerbar, Belastbar {
    public static final double ABSCHREIBUNGSDAUER = 8;
    public static final double VERMOEGENSSTEUERSATZ = 0.10; // 10%
    public static final double BELEIHUNGSFAKTOR = 0.5; // 50%

    private double neupreis;
    private int baujahr;

    public Auto(double neupreis, int baujahr){
        this.neupreis = neupreis;
        this.baujahr = baujahr;
    }

    public double getZeitwert(){
        int alter = LocalDate.now().getYear() - baujahr;
        double restwert = neupreis - (neupreis / ABSCHREIBUNGSDAUER) * alter;
        // Restwert darf nicht negativ sein
        // Math.max(a, b) <-- gibt größere der beiden Argumente zurück
        return Math.max(0, restwert);
    }

    @Override
    public double berechneBeleihungswert() {
        return getZeitwert() * BELEIHUNGSFAKTOR;
    }

    @Override
    public double berechneSteuerBetrag() {
        // Nur Autos mit Zeitwert > 5000€ werden besteuert
        if(getZeitwert() > 5000){
            return getZeitwert() * VERMOEGENSSTEUERSATZ;
        }
        return 0;
    }
}
