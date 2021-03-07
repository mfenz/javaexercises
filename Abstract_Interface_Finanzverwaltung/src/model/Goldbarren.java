package model;

import iface.Besteuerbar;

public class Goldbarren implements Besteuerbar {
    private static final float grammPreis = 45.9f;

    private float gramm;

    public Goldbarren(float gramm) {
        this.gramm = gramm;
    }

    @Override
    public float steuerBetrag() {
        float wert = gramm * grammPreis;
        float steuer = wert * 0.015f;
        System.out.printf("Steuer für %f Gramm Goldbaren beträgt %.2f\n", gramm,
                steuer);
        return wert * 0.015f;
    }
}
