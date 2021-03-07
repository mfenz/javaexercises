import iface.Besteuerbar;
import model.Auto;
import model.Einfamilienhaus;
import model.Goldbarren;

import java.util.List;

public class Finanzverwaltung {
    List<Besteuerbar> objekte;

    public static void main(String[] args) {
        Finanzverwaltung f = new Finanzverwaltung();
        f.steuernEintreiben();
    }

    void steuernEintreiben() {
        // Besteuerbare Objekte anlegen
        Auto a1 = new Auto(2015, 56000f);
        Auto a2 = new Auto(2020, 170500f);
        Goldbarren g1 = new Goldbarren(43.543f);
        Einfamilienhaus efh1 = new Einfamilienhaus(450000f);
        // Aus Objekten eine Liste erstellen
        objekte = List.of(a1, a2, g1, efh1);
        // Steuerbetrag ermitteln
        float steuer = objekte.stream().map(Besteuerbar::steuerBetrag)
                .reduce(0f, Float::sum);
        System.out.printf("Steuer Gesamt = %f\n", steuer);
    }
}
