package com.autoverkauf.konsole.model;

import java.math.BigDecimal;

public class Auto {
    private String marke;
    private String modell;
    private int baujahr;
    private float preis;
//    private BigDecimal preis;

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
