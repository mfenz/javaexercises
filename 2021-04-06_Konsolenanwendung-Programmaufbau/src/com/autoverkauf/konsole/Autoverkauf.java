package com.autoverkauf.konsole;

import com.autoverkauf.konsole.bl.AutoverkaufBl;

import java.util.Scanner;

public class Autoverkauf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AutoverkaufBl bl = new AutoverkaufBl(scanner);

        System.out.println("--- Autoverkauf ---");

        while (true){
            System.out.println("add - Neues Auto hinzufügen; " +
                    "list - Alle Autos anzeigen; " +
                    "exit - Programm beenden");
            System.out.print("Eingabe: ");
            String input = scanner.nextLine();

            switch (input){
                case "add": bl.addAuto(); break;
                case "list": bl.listAutos(); break;
                case "exit": System.exit(0); break;
                default:
                    System.out.printf("Eingabe \"%s\" wurde nicht erkannt. %n", input);
            }
        }
    }
}
