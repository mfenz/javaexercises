package bl;

import service.BlacklistService;
import service.FileBlacklistService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BlacklistBl {
    // Instanzvariable
    private Scanner scanner;
    private BlacklistService blacklistService;

    // Konstruktor
    public BlacklistBl(Scanner scanner){
        this.scanner = scanner;
        blacklistService = new FileBlacklistService();
    }

    public void addBlacklistNames(){
        // User werden hier Namen eingeben
        System.out.println("Bitte die Namen mit Leerzeichen getrennt eingeben");
        String input = scanner.nextLine();
        // Eingabe anhand der Leerzeichen trennen
        String[] names = input.split(" ");
        // Array von Strings in Liste von Strings umwandeln
        List<String> nameList = Arrays.asList(names);

        blacklistService.addNames(nameList);
    }

    public void printBlacklistNames(){
        List<String> names = blacklistService.getNames();
        System.out.println("Folgende Namen sind auf der Blacklist:");
        for(int i = 0; i < names.size(); i++){
            System.out.print(names.get(i));
            // Wenn wir NICHT beim letzten Element sind, Beistrich ausgeben
            if(i != names.size() - 1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void removeBlacklistNames(){
        List<String> names = new ArrayList<>();
        while (true){
            System.out.println("Welcher Name soll gelöscht werden? (done zum Beenden):");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("done")){
                // mit break die Schleife beenden
                break;
            }
            // Input zur Liste hinzufügen
            names.add(input);
        }

        blacklistService.removeNames(names);
        System.out.println("Namen gelöscht.");
    }
}
