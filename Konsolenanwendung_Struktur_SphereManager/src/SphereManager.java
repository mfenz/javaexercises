import bl.SphereManagerBl;

import java.util.Scanner;

public class SphereManager {
    public static void main(String[] args) {
        // Dieses Scanner-Objekt werden wir im ganzen Programm verwenden
        Scanner scanner = new Scanner(System.in);
        // BL-Objekt erstellen und Scanner mitgeben
        SphereManagerBl bl = new SphereManagerBl(scanner);
        System.out.println("--- SPHERE MANAGER ---");
        // Hauptmenü
        while (true){
            System.out.println("add: Ball speichern; list: alle Bälle ausgeben");
            System.out.print("Eingabe: ");
            String choice = scanner.nextLine();
            switch (choice){
                case "add": bl.addSphere(); break;
                case "list": bl.listSpheres(); break;
                default:
                    System.out.printf("Eingabe \"%s\" nicht erkannt.%n", choice);
            }
        }
    }
}
