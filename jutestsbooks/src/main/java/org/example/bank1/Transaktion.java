package org.example.bank1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaktion {
    private double betrag;
    private String text;
    private LocalDate datum;

    public Transaktion(double betrag, String text, LocalDate datum) {
        this.betrag = betrag;
        this.text = text;
        this.datum = datum;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
