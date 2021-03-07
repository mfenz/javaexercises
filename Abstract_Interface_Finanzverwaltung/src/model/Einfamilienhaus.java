package model;

import iface.Besteuerbar;

public class Einfamilienhaus implements Besteuerbar {
    private float verkehrswert;

    public Einfamilienhaus(float verkehrswert) {
        this.verkehrswert = verkehrswert;
    }

    @Override
    public float steuerBetrag() {

        float steuer = verkehrswert * 0.005f;
        System.out.printf("Steuer für EFH mit Verkehrswert %.2f beträgt %.2f\n",
                verkehrswert, steuer);
        return steuer;
    }
}
