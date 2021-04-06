package com.autoverkauf.konsole.bl;

import com.autoverkauf.konsole.model.Auto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutoverkaufBl {
    private Scanner scanner;
    private List<Auto> autos = new ArrayList<>();
    public AutoverkaufBl(Scanner scanner){
        this.scanner = scanner;
    }

    public void addAuto(){
        System.out.println("--- Auto anlegen ---");
        System.out.println("Marke eingeben:");
        String marke = scanner.nextLine();
        System.out.println("Modell eingeben:");
        String modell = scanner.nextLine();
        System.out.println("Baujahr eingeben:");
        while(!scanner.hasNextInt()){
            System.out.println("Ungültige Eingabe!");
            scanner.next(); // input buffer leeren
        }
        int baujahr = scanner.nextInt();
        scanner.nextLine(); // Zeilenumbruch vom input stream holen
        System.out.println("Preis eingeben:");
        while(!scanner.hasNextFloat()){
            System.out.println("Ungültige Eingabe!");
            scanner.next(); // input buffer leeren
        }
//        // 15000,3
//        String preisString = scanner.nextLine();
//        String[] split = preisString.split(",");
//        int cent = Integer.parseInt(split[0]) * 100 + Integer.parseInt(split[1]);
        float preis = scanner.nextFloat();
        scanner.nextLine(); // Zeilenumbruch vom input stream holen
        // Neues Objekt der Klasse Auto erstellen
        Auto auto = new Auto(marke, modell, baujahr, preis);
        autos.add(auto);
        System.out.println("Auto erfolgreich angelegt:");
        print(auto);
    }

    public void listAutos(){
        for(Auto auto : autos){
            print(auto);
        }
    }

    public void print(Auto auto){
        System.out.printf("%s %s, Baujahr %d Preis %f %n",
                auto.getMarke(), auto.getModell(), auto.getBaujahr(), auto.getPreis());
    }
}
