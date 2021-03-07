package model;

import iface.Besteuerbar;

import java.time.LocalDate;

public class Auto implements Besteuerbar {

    private static final float abschreibungsdauer = 10.0f;

    int baujahr;
    float neupreis;

    public Auto(int baujahr, float neupreis) {
        this.baujahr = baujahr;
        this.neupreis = neupreis;
    }

    @Override
    public float steuerBetrag() {
        int alter = LocalDate.now().getYear() - baujahr;
        float restwert =
                (neupreis / abschreibungsdauer) * (abschreibungsdauer - alter);
        // Nur Autos mit Restwert > 10.000€ besteuern
        float steuer;
        if (restwert > 10000f) {
            steuer = restwert * 0.05f;
        } else {
            steuer = 0;
        }
        System.out.printf("Steuer für Auto mit BJ %d und NP %.2f beträgt %.2f\n",
                baujahr, neupreis, steuer);
        return steuer;
    }
}
