package at.cb.minmax;

import at.cb.minmax.operations.MinMaxBetrunken;
import at.cb.minmax.operations.MinMaxFinder;
import at.cb.minmax.operations.MinMaxWithListSort;
import at.cb.minmax.operations.MinMaxWithLoop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MinMax {
    public static void main(String[] args) {
        MinMax mm = new MinMax();
        mm.mainMenu();
    }

    // Hier werden die Zahlen gespeichert
    private List<Integer> values = new ArrayList<>();
    private MinMaxFinder minMaxFinder;

    public void mainMenu(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("-------------------------");
            System.out.println("add - fügt 10 automatisch generierte Zahlen hinzu");
            System.out.println("print - zeigt alle Zahlen an");
            System.out.println("loop - setzt Schleifen Interface");
            System.out.println("sort - setzt Sortieren Interface");
            System.out.println("falsch - setzt falsch implementiertes Interface");
            System.out.println("minmax - findet min und max der Zahlen");
            System.out.println("exit - Programm beenden");

            String input = scanner.nextLine();
            switch (input){
                case "add":
                    addValues();
                    break;
                case "print":
                    printValues();
                    break;
                case "loop":
                    setLoopImplementation();
                    break;
                case "sort":
                    setSortImplementation();
                    break;
                case "falsch":
                    setWrongImplementation();
                    break;
                case "minmax":
                    findMinMaxValues();
                    break;
                case "exit":
                    System.out.println("Ciao!");
                    System.exit(0);
            }
        }
    }

    private void addValues(){
        // fügt der Liste 10 Zahlen hinzu
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            // nextInt(high-low)+low
            values.add(random.nextInt(5000 - 1) + 1);
        }
    }

    private void printValues(){
        // Ausgabe aller Zahlen auf der Konsole
        for(int zahl : values){
            System.out.print(zahl + ", ");
        }
        System.out.println();
    }

    private void setLoopImplementation(){
        // MinMaxWithLoop Implementierung auswählen
        minMaxFinder = new MinMaxWithLoop();
        System.out.println("Implementierung mit Schleife ausgewählt.");
    }

    private void setSortImplementation(){
        // MinMaxWithListSort Implementierung wählen
        minMaxFinder = new MinMaxWithListSort();
        System.out.println("Implementierung mit Liste und Sortierung ausgewählt.");
    }

    private void setWrongImplementation(){
        minMaxFinder = new MinMaxBetrunken();
        System.out.println("Falsche Implementierung ausgewählt.");
    }

    private void findMinMaxValues(){
        // minimum und max. finden und ausgeben

        // prüfen ob minMaxFinder initialisiert ist
        if(minMaxFinder == null){
            System.out.println("Bitte zuerst eine Implementierung wählen!");
            return;
        }

        int min = minMaxFinder.findMin(values);
        int max = minMaxFinder.findMax(values);
        System.out.printf("Min: %d, max: %d %n", min, max);
    }
}
