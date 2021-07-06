package at.cb.addierer;

import java.util.Scanner;

public class Addierer {
    // Instanzvariablen
    Scanner scanner = new Scanner(System.in);

    private int summe;

    // User können eingeben was sie tun möchte:
    // add - fügt eine Zahl hinzu (addieren)
    // summe - zeigt die Summe an

    public static void main(String[] args){
        Addierer add = new Addierer();
        add.hauptmenue();
    }

    public void hauptmenue(){

        // while-Schleife
        while(true){
            System.out.println("Was möchten Sie tun?");
            System.out.println("add <-- fügt eine Zahl hinzu");
            System.out.println("summe <-- zeigt die Summe der eingegebenen Zahlen an");

            String eingabe = scanner.nextLine();
            switch(eingabe) {
                case "add":
                    add();
                    break;
                case "summe":
                    summenAusgabe();
                    break;
                default:
                    System.out.printf("'%s' ist keine gültige Eingabe! %n", eingabe);
            }
        }
    }

    public void add(){
        System.out.println("Bitte eine Zahl eingeben:");
        int zahl = scanner.nextInt();
        scanner.nextLine();

        // summe += zahl;
        // summe = summe + zahl;
        summe += zahl;
    }

    public void summenAusgabe(){
        System.out.printf("Die Summe ist %d %n", summe);
    }
}
