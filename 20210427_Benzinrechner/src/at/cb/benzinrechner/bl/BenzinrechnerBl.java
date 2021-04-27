package at.cb.benzinrechner.bl;

import at.cb.benzinrechner.model.Tankvorgang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BenzinrechnerBl {
    private Scanner scanner; // wird über Konstruktor initialisiert
    // <Datentyp> <-- Generics, Angabe des Datentyps der Listen-Elemente
    private List<Tankvorgang> vorgaenge = new ArrayList<>();

    public BenzinrechnerBl(Scanner scanner){
        this.scanner = scanner;
    }

    // Tankvorgang eingeben
    public void addTankvorgang(){
        System.out.println("Bitte die getankten Liter eingeben:");
        // Um die Eingabe zu prüfen
        while (!scanner.hasNextFloat()){
            scanner.nextLine(); // falsche Werte von Konsole löschen
        }
        // Eingabe der Liter von Konsole holen
        float liter = scanner.nextFloat();

        System.out.println("Die gefahrene Distanz eingeben (km):");
        // Prüfen ob Eingabe korrekt war
        while (!scanner.hasNextFloat()){
            scanner.nextLine();
        }
        float km = scanner.nextFloat();

        System.out.println("Betrag in Euro eingeben:");
        while (!scanner.hasNextFloat()){
            scanner.nextLine();
        }
        float betrag = scanner.nextFloat();
        scanner.nextLine(); // damit newLine Char gelöscht wird

        // Objekt erstellen
        Tankvorgang vorgang = new Tankvorgang(liter, km, betrag);
        // Objekte in Liste einfügen
        // variablennameliste.add(objekt);
        vorgaenge.add(vorgang);
        System.out.println("Tankvorgang hinzugefügt.");
    }

    // Alle Tankvorgänge ausgeben lassen
    public void listTankvorgaenge(){
        // vorgaenge.size() <-- Anzahl der Elemente in der Liste
        for(int i = 0; i < vorgaenge.size(); i++){
            // Jedes Objekt einzeln aus der Liste holen
            Tankvorgang tankvorgang = vorgaenge.get(i);
            print(tankvorgang);
        }
    }

    // Ausgabe von einem Tankvorgang-Objekt auf der Konsole
    public void print(Tankvorgang tankvorgang){
        // %6.2f <-- 2 Nachkommastellen, 1 Kommastelle (= 3 Stellen)
        // bleibt 6-3 = 3 Stellen für Vorkommastellen übrig
        System.out.printf("%6.2f l %7.2f km %6.2f € %6.2f l/100km %6.2f€/km %n",
                tankvorgang.getLiter(), tankvorgang.getDistanzKm(),
                tankvorgang.getBetrag(), tankvorgang.getVerbrauchLiterPro100km(),
                tankvorgang.getKostenProKm());
    }

    // Statistik für alle Tankvorgänge ausgeben lassen
    public void printStatistik(){
        // Durchschnittsverbrauch aller Tankvorgänge

        float sumLiter = 0.0f;
        float sumKm = 0.0f;
        for(int i = 0; i < vorgaenge.size(); i++){
            Tankvorgang vorgang = vorgaenge.get(i);
            // Summe aller liter und km bilden
            sumLiter += vorgang.getLiter();
            sumKm += vorgang.getDistanzKm();
        }
        float durchschnittsVerbrauch = (sumLiter / sumKm) * 100;
        System.out.printf("Der Durchschnittsverbrauch über %.2f km beträgt %.2f l/100km %n",
                sumKm, durchschnittsVerbrauch);
    }
}
