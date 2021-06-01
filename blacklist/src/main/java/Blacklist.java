import bl.BlacklistBl;

import java.util.Scanner;

public class Blacklist {
    public static void main(String[] args) {
        Blacklist b = new Blacklist();
        b.mainMenu();
    }

    public void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        BlacklistBl bl = new BlacklistBl(scanner);

        while (true){
            System.out.println("-----------------------------------");
            System.out.println("add: Namen zur Blacklist hinzufügen");
            System.out.println("list: Alle Namen der Blacklist ausgeben");
            System.out.println("remove: Namen von der Blacklist löschen");
            System.out.println("check: Prüfen ob ein Name auf der Blacklist ist");
            System.out.println("exit: Programm beenden");

            String input = scanner.nextLine();
            switch (input) {
                case "add":
                    bl.addBlacklistNames();
                    break;
                case "list":
                    bl.printBlacklistNames();
                    break;
                case "remove":
                    bl.removeBlacklistNames();
                    break;
                case "check":
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Eingabe wurde nicht erkannt!");
                    break;
            }
        }
    }
}
