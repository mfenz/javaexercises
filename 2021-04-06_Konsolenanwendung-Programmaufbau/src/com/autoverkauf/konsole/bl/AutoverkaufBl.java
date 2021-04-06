package com.autoverkauf.konsole.bl;

import com.autoverkauf.konsole.model.Auto;

import java.util.Scanner;

public class AutoverkaufBl {
    Scanner scanner;
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
        float preis = scanner.nextFloat();
        scanner.nextLine(); // Zeilenumbruch vom input stream holen
        Auto auto = new Auto(marke, modell, baujahr, preis);
    }

    public void listAutos(){

    }

    public void print(Auto auto){

    }
}
