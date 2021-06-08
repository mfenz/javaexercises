package at.cb.userverwaltung;

import at.cb.userverwaltung.bl.UserVerwaltungBl;

import java.util.Scanner;

public class UserVerwaltung {
    public static void main(String[] args) {
        UserVerwaltung uv = new UserVerwaltung();
        uv.hauptmenue();
    }

    // User hinzufügen
    // Alle User ausgeben lassen

    public void hauptmenue(){
        Scanner scanner = new Scanner(System.in);
        UserVerwaltungBl bl = new UserVerwaltungBl(scanner);

        while (true){
            System.out.println("add: User hinzufügen");
            System.out.println("list: Alle User anzeigen");
            String input = scanner.nextLine();
            switch (input){
                case "add":
                    bl.addUser();
                    break;
                case "list":
                    bl.listUsers();
                    break;
                default:
                    System.out.println("Eingabe nicht erkannt.");
            }
        }
    }
}
