import java.util.Scanner;

public class Schleifen {
    public static void main(String[] args) {
        int zahl = 1;
        // Wenn
        if(zahl < 5){
            System.out.println("Zahl < 5!");
        } else {
            System.out.println("Zahl >= 5!");
        }

        // While-Schleife
        // Solange
        // zahl < 5 <-- Schleifenbedingung
        while (zahl < 5){
            // Schleifeninhalt
            System.out.println("While: Zahl < 5! Zahl="+zahl);
            zahl = zahl + 1;
        }

        // For-Schleife
        // i --> Laufvariable
        for(int i = 1; i < 5; i++){
            // Schleifeninhalt
        }

        // While und for: Kopfgesteuerte Schleifen
        // do-while: Fußgesteuerte Schleife

        zahl = 0;
        do {
            System.out.println("Zahl: " + zahl);
            // Do wird immer zumindest einmal ausgeführt!
            zahl = zahl / 2;
        } while(zahl != 0); // Danach while--> Wenn while true --> do



        // mindestens 6 Buchstaben, @ Zeichen muss vorkommen
        Scanner scanner = new Scanner(System.in);
        String eingabe;
        int versuche = 0;
        do {
            System.out.println("Bitte das Passwort eingeben (mind. 6 Zeichen, und @ Zeichen)");
            eingabe = scanner.nextLine();
            versuche++;
            if(versuche > 5){
                System.out.println("Zu viele Versuche. Sorry!");
            }
        } while(eingabe.length() < 6 || !eingabe.contains("@"));

        System.out.println("Super! " + eingabe);

    }
}
