package at.cb.benzinrechner;

import java.util.Scanner;

public class Benzinrechner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("add: Tankvorgang eingeben");
            System.out.println("list: Tankvorgänge ausgeben");
            System.out.println("stats: Statistik ausgeben");
            System.out.println("exit: Programm beenden");
            // Auf die User-Eingabe warten
            String input = scanner.nextLine();
            switch (input){
                case "add":
                    break;
                case "list":
                    break;
                case "stats":
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Ungültige Eingabe!");
            }
        }
    }
}
