package at.cb.schleifen;

public class Schleifen {
    public static void main(String[] args) {
        // Geben Sie die Zahlen von 70 bis 100 Zeile für Zeile auf der Konsole aus
        System.out.println("Zahlen von 70 bis 100, Zeile für Zeile, auf der Konsole:");

        // i++ ist gleich wie i = i + 1;
        // for(INIT; SCHLEIFENBEDINGUNG; VERÄNDERUNG) { SCHLEIFENKÖRPER }
        for(int i = 70; i <= 100; i++) {
            // Schleifenkörper (zu wiederholende Tätigkeit)
            // i wird für %d eingesetzt
            System.out.printf("i=%d %n", i);
        }

        // kein Beistrich nach der letzten Zahl
        System.out.println("Zahlen von 70 bis 100, mit Beistrich getrennt, auf der Konsole:");
        for(int i = 70; i <= 100; i++){
            // System.out.print() <-- Ausgabe ohne Zeilenumbruch
            System.out.print(i);
            // Wenn ich NICHT bei der letzten Zahl bin, dann einen Beistrich ausgeben
            // Bedingung: Wenn ich NICHT bei der letzten Zahl bin
            // i < 100 Alternativ i != 100
            if(i != 100){
                // wenn NICHT bei der letzten Zahl, dann Beistrich ausgeben
                System.out.print(", ");
            }
        }

        // Ausgabe und zum Schluss einen Zeilenumbruch
        System.out.println();
        System.out.println("Zahlen von 120 bis 100, mit Beistrich getrennt, auf Konsole:");
        for(int i = 120; i >= 100; i--){
            // Ausgabe der Zahl
            System.out.printf("i=%d", i);
            // wenn wir nicht bei der letzten Zahl sind, Beistrich ausgeben
            if(i != 100){
                // Ausgabe (ohne Zeilenumbruch zum Schluss)
                System.out.print(", ");
            }
        }
        // Am Ende der Schleife einen Zeilenumbruch damit man danach eine neue Zeile hat
        System.out.println();

        System.out.println("Ausgabe von einem String: Jedes Zeichen soll mit " +
                "Beistrich getrennt extra ausgegeben werden Hello --> H, e, l, l, o");
        String text = "Hello";
        // text.length() <-- Anzahl der Zeichen im String: Hello --> 5
        // text.charAt(index) <-- Liefert das Zeichen am gegebenen Index "Hello".charAt(0) --> H
        // text.charAt(index) <-- Liefert das Zeichen am gegebenen Index "Hello".charAt(4) --> o
        for(int i = 0; i < text.length(); i++) {
            // Einzelnes Zeichen aus String holen
            char zeichen = text.charAt(i);
            // Immer das Zeichen ausgeben
            System.out.print(zeichen);
            // Wenn wir nicht beim letzten Zeichen sind, dann einen Beistrich ausgeben
            // Der letzte Index ist immer .length() - 1
            if(i != text.length() - 1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
