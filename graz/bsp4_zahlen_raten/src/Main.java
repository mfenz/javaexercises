import java.util.Random;
import java.util.Scanner;

public class Main {
    // Static-Methode gehört immer zur Klasse (hier zur Klasse Main)
    // Nicht-Static-Methode gehört immer zu einem Objekt einer Klasse
    public static void main(String[] args) {
        Random random = new Random();
        int zz = random.nextInt(100);

        // Erzeuge ein Objekt der Klasse Main
        // Objekt wird immer mit new Klassenname(); erzeugt
        Main mainObject = new Main();
        // rufe für das Objekt die Methode zahlenraten() auf
        mainObject.zahlenraten();
    }

    /**
     * private: von außerhalb der Klasse kann darauf nicht zugegriffen werden
     * void: Rückgabedatentyp, void: die Methode gibts nichts zurück
     * zahlenraten: Name der Methode (prinzipiell frei wählbar)
     * (): Übergabeparameter
     */
    private void zahlenraten(){
        Scanner scanner = new Scanner(System.in);
        // wähle eine zufällige Zahl im Bereich 1-100 und merke sie dir in "randomNumber"
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        // definiere counter und setze auf 0
        int counter = 0;

        // wiederhole solange die korrekte Zahl nicht erraten wurde:
        boolean erraten = false;
        while(erraten == false)
        {
            //      frage User nach seiner "guess" und merke sie dir in "guess"
            System.out.println("Bitte eine Zahl raten:");
            int guess = scanner.nextInt();
            // erhöhe counter um 1 (schließlich war hier ja ein weiterer Versuch...)
            counter++;

            if(guess < randomNumber){
                //      wenn guess < randomNumber:
                //      - "Gesuchte Zahl ist größer!" ausgeben
                System.out.println("Die gesuchte Zahl ist größer!");
            } else if(guess > randomNumber){
                //      oder wenn guess > randomNumber:
                //      - "Gesuchte Zahl ist kleiner!" ausgeben
                System.out.println("Die gesuchte Zahl ist kleiner!");
            } else {
                //      oder wenn guess gleich ist wie randomNumber:
                //      - "Gratulation, gewonnen!" ausgeben
                //      - Spiel beendet
                System.out.println("Gratulation, gewonnen!");
                System.out.println("Du hast " + counter + " Versuche benötigt.");
                erraten = true;
            }
        }




    }
}