package at.cb.stringumdrehen;

public class StringUmdrehen {
    public static void main(String[] args) {
        // Marc --> craM

        // String: Zeichenkette
        String name = "Marc";
        // String charAt(index); Methode um auf ein einzelnes Zeichen zuzugreifen
        // index 0: das erste Zeichen
        // index 1: das zweite Zeichen ...
        // char <-- Datentyp ein einzelnes Zeichen
        char zeichen = name.charAt(3); // c
        char erstesZeichen = name.charAt(0); // M

        // String length() <-- Anzahl der Zeichen im String
        int anzZeichen = name.length(); // 4 (bei Marc)

        name = "Marc"; // length: 4, Index letztes Zeichen: 3
        name = "Trixi"; // length: 5, Index letztes Zeichen: 4
        name = "Kerstin"; // length: 7, Index letztes Zeichen: 6
        name = "Anna";

        // Index vom letzten Zeichen ist immer .length() - 1
        int indexLetztesZeichen = name.length() - 1;


        // Marc --> craM
        String resultat = "";

        // for(INITIALISIERUNG; SCHLEIFENBEDINGUNG; VERÄNDERUNG)
        // {
        //      SCHLEIFENKÖRPER (Code der wiederholt wird)
        // }
        // i-- ist gleich wie i = i - 1;
        for(int i = name.length() - 1; i >= 0; i--){
            // Einzelnen Buchstaben aus String holen
            // name.charAt(i) holt Zeichen an der Index-Position i  aus der Variable name
            char buchstabe = name.charAt(i);
            // resultat += buchstabe; ist gleich wie resultat = resultat + buchstabe;
            resultat += buchstabe;
        }
        System.out.printf("Aus %s wurde %s %n", name, resultat);

        StringUmdrehen stringUmdrehen = new StringUmdrehen();
        stringUmdrehen.stringUmdrehen("Anna");
        stringUmdrehen.stringUmdrehen("Marc");
        stringUmdrehen.stringUmdrehen("David");
    }

    public void stringUmdrehen(String name)
    {
        // Marc --> craM
        String resultat = "";
        for(int i = name.length() - 1; i >= 0; i--){
            // Einzelnen Buchstaben aus String holen
            // name.charAt(i) holt Zeichen an der Index-Position i  aus der Variable name
            char buchstabe = name.charAt(i);
            // resultat += buchstabe; ist gleich wie resultat = resultat + buchstabe;
            resultat += buchstabe;
        }
        System.out.printf("Aus %s wurde %s %n", name, resultat);
    }
}
