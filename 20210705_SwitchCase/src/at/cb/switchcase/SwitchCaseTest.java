package at.cb.switchcase;

import java.util.Scanner;

public class SwitchCaseTest {
    public static void main(String[] args){
        // Objekt der Klasse SwitchCaseTest erstellen
        SwitchCaseTest t = new SwitchCaseTest();

        t.sc1();
    }

    public void sc1(){
        Scanner scanner = new Scanner(System.in);
        // User sagen was zu tun ist
        System.out.println("Welchen Euro-Schein haben Sie?");
        // User-Eingabe durchführen
        int eingabe = scanner.nextInt();

        switch(eingabe) {
            case 5:
                System.out.println("Fünf ist der kleinste Schein.");
                break; // <-- break beendet das switch-case
            case 10:
                System.out.println("Zehn ist der zweitkleinste Schein.");
                break;
            case 20:
                System.out.println("Zwanzig ist zwei mal zehn.");
                break;
            case 50:
                System.out.println("Fünfzig ist mehr als zwanzig.");
                break;
            case 100:
                System.out.println("Hundert ist 10 mal 10");
                break;
            case 200:
                System.out.println("Zweihundert sieht man selten");
                break;
            case 500:
                System.out.println("Den gibt's (fast) nicht mehr.");
                break;
            default: // <-- wenn bisher kein case zugetroffen hat
                System.out.printf("%d ist kein Euroschein.", eingabe);
        }
    }

    public void sc2(){

    }
}
