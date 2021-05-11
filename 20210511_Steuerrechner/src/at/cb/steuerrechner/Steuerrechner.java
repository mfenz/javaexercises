package at.cb.steuerrechner;

import at.cb.steuerrechner.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Den jährlichen Steuerbetrag (Vermögenssteuer) für
 * Wertgegenstände ermitteln
 */
public class Steuerrechner {
    public static void main(String[] args) {
        // Objekt erstellen
        Steuerrechner steuerrechner = new Steuerrechner();
        // Werte hinzufügen
        steuerrechner.add();
        // Steuerbetrag ausgeben
        steuerrechner.printSteuerBetrag();
        // Beleihungswert ausgeben
        steuerrechner.printBeleihungswert();
    }

    List<Besteuerbar> besteuerbar = new ArrayList<>();
    List<Belastbar> belastbar = new ArrayList<>();

    public void add(){
        // Objekt erstellen
        Einfamilienhaus efh1 = new Einfamilienhaus(450000);
        // Objekt in die Listen einfügen
        besteuerbar.add(efh1);
        belastbar.add(efh1);

        Goldbarren gb1 = new Goldbarren(20.43);
        besteuerbar.add(gb1);
        belastbar.add(gb1);

        Goldbarren gb2 = new Goldbarren(15);
        besteuerbar.add(gb2);
        belastbar.add(gb2);

        Auto auto1 = new Auto(30000, 2018);
        besteuerbar.add(auto1);
        belastbar.add(auto1);

        Auto auto2 = new Auto(170000, 2019);
        besteuerbar.add(auto2);
        belastbar.add(auto2);
    }

    public void printSteuerBetrag(){
        // Steuerbetrag berechnen
        double steuerSumme = 0.0;
        // Enhanced for loop
        // for(Datentylliste var : listenname){}
        for(Besteuerbar b : besteuerbar){
            steuerSumme += b.berechneSteuerBetrag();
        }
        System.out.printf("Der Steuerbetrag beträgt %.2f € %n", steuerSumme);
    }

    public void printBeleihungswert(){
        double beleihungswert = 0.0;
        for(Belastbar b : belastbar){
            beleihungswert += b.berechneBeleihungswert();
        }
        System.out.printf("Der Beleihungswert beträgt %.2f € %n", beleihungswert);
    }
}
