package at.cb.schaltjahrtest;

import at.cb.schaltjahrtest.model.Jahr;

import java.util.Scanner;

public class Schaltjahrtest {
    public static void main(String[] args) {
        // Objekt der Klasse Schaltjahrtest erzeugen
        Schaltjahrtest s = new Schaltjahrtest();
        // Mit dem Punktoperator können Methoden des Objekts aufgerufen werden
        // Methode test() aufrufen
        s.test();


    }

    public void test(){
        // new Scanner() <-- erzeugt ein Objekt der Klasse Scanner
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Bitte eine Jahreszahl eingeben:");
            int jahr = scanner.nextInt();

            Jahr jahrTest = new Jahr(jahr);
            boolean schaltjahr = jahrTest.isSchaltjahr();
            if(schaltjahr){
                System.out.printf("Das Jahr %d ist ein Schaltjahr!%n", jahrTest.getJahr());
                break; // beendet die Ausführung einer Schleife
            } else {
                System.out.printf("Das Jahr %d ist kein Schaltjahr!%n", jahrTest.getJahr());
            }
        }
    }

    public void test2(){
        // new Scanner() <-- erzeugt ein Objekt der Klasse Scanner
        Scanner scanner = new Scanner(System.in);

        boolean schaltjahrGefunden = false;
        while (!schaltjahrGefunden){
            System.out.println("Bitte eine Jahreszahl eingeben:");
            int jahr = scanner.nextInt();

            Jahr jahrTest = new Jahr(jahr);
            schaltjahrGefunden = jahrTest.isSchaltjahr();
            if(schaltjahrGefunden){
                System.out.printf("Das Jahr %d ist ein Schaltjahr!%n", jahrTest.getJahr());
            } else {
                System.out.printf("Das Jahr %d ist kein Schaltjahr!%n", jahrTest.getJahr());
            }

            while (true){
                // ...
                schaltjahrGefunden = true;
                break;
            }
        }
    }
}
