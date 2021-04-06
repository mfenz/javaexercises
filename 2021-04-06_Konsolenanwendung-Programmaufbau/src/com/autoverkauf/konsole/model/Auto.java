package com.autoverkauf.konsole.model;

public class Auto {
    private String marke;
    private String modell;
    private int baujahr;
    private float preis;

    public Auto(String marke, String modell, int baujahr, float preis){
        this.marke = marke;
        this.modell = modell;
        this.baujahr = baujahr;
        this.preis = preis;
    }

    public String getMarke() {
        return marke;
    }

    public String getModell() {
        return modell;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public float getPreis() {
        return preis;
    }
}
