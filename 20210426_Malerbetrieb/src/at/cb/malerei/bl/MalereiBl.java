package at.cb.malerei.bl;

import at.cb.malerei.model.Rechteck;

import java.util.ArrayList;
import java.util.List;

public class MalereiBl {

    // Konstante
    // static: nur ein mal im ganzen Programm
    // final: Wert nicht mehr veränderbar
    private static final float LITER_FARBE_PRO_M2 = 0.170f;

    private List<Rechteck> flaechen = new ArrayList<>();
    private List<Rechteck> freiflaechen = new ArrayList<>();

    public void addFlaechen(){
        // Objekte erstellen
        Rechteck wand1 = new Rechteck(2.7f, 6f);
        Rechteck wand2 = new Rechteck(2.7f, 6f);
        Rechteck wand3 = new Rechteck(2.7f, 4.3f);
        Rechteck wand4 = new Rechteck(2.7f, 4.3f);
        Rechteck decke = new Rechteck(6f, 4.3f);
        // Objekte jeweils ans Ende der Liste hinzufügen
        flaechen.add(wand1); // Index 0
        flaechen.add(wand2); // Index 1
        flaechen.add(wand3);
        flaechen.add(wand4);
        flaechen.add(decke);
    }

    public void addFreiflaechen(){
        Rechteck tuer = new Rechteck(2.0f, 1.0f);
        Rechteck fenster = new Rechteck(1.0f, 1.0f);
        freiflaechen.add(tuer);
        freiflaechen.add(fenster);
    }

    public float calculateGesamtFlaeche(){
        float flaechenSumme = 0.0f;
        // Über jedes Rechteck-Objekt in der flaechen Liste
        for(Rechteck r : flaechen){
            // Fläche eines Rechtecks zur (Teil-) Summe dazurechnen
            flaechenSumme += r.getFlaeche();
        }

        float freiflaechenSumme = 0.0f;
        // freiflaechen.size() <-- wie viele Elemente in der Liste sind
        for(int i = 0; i < freiflaechen.size(); i++){
            // .get(i) holt das Objekt an der Stelle i aus der Liste
            Rechteck rechteck = freiflaechen.get(i);
            freiflaechenSumme += rechteck.getFlaeche();
        }

        float zuMalendeFlaeche = flaechenSumme - freiflaechenSumme;
        return zuMalendeFlaeche;
    }

    public float calculateFarbMenge(){
        // Methode aufrufen, Rückgabewert speichern
        float flaeche = calculateGesamtFlaeche();
        return LITER_FARBE_PRO_M2 * flaeche;
    }

    public void printBenoetigteFarbMenge(){
        float farbMengeLiter = calculateFarbMenge();
        System.out.printf("Wir empfehlen die Bestellung von" +
                " %f l Farbe. %n", farbMengeLiter);
    }
}
