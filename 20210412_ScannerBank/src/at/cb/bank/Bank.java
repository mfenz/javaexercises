package at.cb.bank;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie heißen Sie? Bitte eingeben:");
        String name = scanner.nextLine();

        System.out.println("Wie viel Geld wollen Sie einzahlen?");
        while(!scanner.hasNextDouble()){
            System.out.println("Ungültige Eingabe!");
            scanner.nextLine(); // Input stream mit falscher Eingabe leeren
        }
        // scanner.nextDouble() liest die Zahl vom Input-Stream ein,
        // lässt jedoch das Enter am Input-Stream
        double einzahlBetrag = scanner.nextDouble();
        scanner.nextLine(); // leert "Enter" vom Input-Stream

        System.out.printf("Willkommen %s, Sie wollen %.2f € einzahlen? %n",
                name, einzahlBetrag);

        System.out.println("Wie alt sind Sie?");
        while(!scanner.hasNextInt()){
            System.out.println("Ungültige Eingabe!");
            // liest die gesamte Zeile ein. Gibt sie als String zurück.
            // leer dann den input stream
            scanner.nextLine(); // Input stream mit falscher Eingabe leeren
        }
        int alter = scanner.nextInt();
        scanner.nextLine(); // leert "Enter" vom Input-Stream
        if(alter < 18) {
            System.out.printf("Behalt' deine %.2f, komm bald wieder", einzahlBetrag);
            System.exit(0);
        } else {
            System.out.println("Super, das passt schon.");
        }

        System.out.println("Wie lautet Ihre Kontonummer?");
        String kontoNummerStr = scanner.nextLine();
        int kontoNummer = Integer.parseInt(kontoNummerStr);
        System.out.printf("Danke, Ihre Kontonummer ist %d %n", kontoNummer);
    }
}
