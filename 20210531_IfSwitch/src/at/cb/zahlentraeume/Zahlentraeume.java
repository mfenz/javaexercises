package at.cb.zahlentraeume;

import java.util.Scanner;

public class Zahlentraeume {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte eine Zahl eingeben:");
        int zahl = scanner.nextInt();

        if(zahl >= 1 && zahl <= 5){
            System.out.println("Die Zahl liegt zwischen 1 und 5.");
        } else if(zahl >= 6 && zahl <= 10) {
            System.out.println("Die Zahl liegt zwischen 6 und 10.");
            if(zahl == 10){
                System.out.println("Jackpot!");
            }
        } else if(zahl == 0){
            System.out.println("Die Zahl darf nicht 0 sein!");
        } else {
            System.out.println("Die Zahl ist zu groß, oder zu klein.");
        }

        System.out.println("Bitte das Kommando eingeben (list, add, exit):");
        String kommando = scanner.nextLine();
        switch (kommando){
            case "list":
                System.out.println("Liste aller User ausgeben ...");
                break;
            case "add":
                System.out.println("Neuen User hinzufügen ...");
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("Bitte ENDLICH!!! korrekte Eingaben machen!!!");
        }
    }
}
