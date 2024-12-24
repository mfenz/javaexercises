import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Frage User welche Note umgewandelt werden soll. Merke es in "note"
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte die Note als Zahl eingeben:");
        int note = scanner.nextInt();

        // wenn die Eingabe "note" 1 ist, dann gebe "Sehr Gut" aus
        if(note == 1){
            System.out.println("Sehr Gut");
        } else if(note == 2){
            // ansonsten: wenn die Eingabe "note" 2 ist, dann gebe "Gut" aus
            System.out.println("Gut");
        } else if(note == 3){
            // ansonsten: wenn die Eingabe "note" 3 ist, dann gebe "Befriedigend" aus
            System.out.println("Befriedigend");
        } else if(note == 4){
            // ansonsten: wenn die eingabe "note" 4 ist, dann gebe "Genügend" aus
            System.out.println("Genügend");
        } else if(note == 5){
            // ansonsten: wenn die Eingabe in "note" 5 ist, dann gebe "Nicht genügend" aus
            System.out.println("Nicht Genügend");
        } else {
            // falls davor nichts zugetroffen hat, gebe "NOTE ist ungültig" aus
            System.out.println(note + " ist ungültig!");
        }
    }
}