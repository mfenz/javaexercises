package at.cb.schleifen;

public class Schleifen {
    public static void main(String[] args) {
        // Zahlen von 25 bis 35 auf Konsole ausgeben
        // for(initialisierung; Schleifenbedingung; Veränderung){ Schleifenkörper }
        // i++ ist gleich wie i = i + 1
        for(int i = 25; i <= 35; i++) {
            System.out.println("i="+i);
        }
        System.out.println("Nach der Schleife");

        System.out.println("Zahlen von 10 bis 20 in 2er-Schritten ausgeben");
        // Zahlen von 10 bis 20 in 2er-Schritten ausgeben
        // i += 2 ist gleich wie i = i + 2;
        for(int i = 10; i <= 20; i += 2)
        {
            System.out.println("i="+i);
        }

        System.out.println("Buchstaben ausgeben:");
        String text = "Hallo Welt";
        // solange i < 10 (text.length())
        for(int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            System.out.println("i=" + i + " Buchstabe: " + c);
        }

        System.out.println("Umgekehrte Ausgabe:");
        // i-- gleich wie i = i -1
        for(int i = text.length() - 1; i >= 0; i--){
            // Buchstaben anhand vom Index herausholen
            char c = text.charAt(i);
            System.out.println(c);
        }

        // for Schleife von 1 bis 10
        for(int i = 1; i <= 100; i++){

        }
        // while Schleife von 1 bis 10
        int i = 1;
        while (i <= 100){

            i++;
        }














        String line = file.readLine();
        while (line != null){
            // Zeile bearbeiten
            // ...


            line = file.readLine();
        }

        boolean angekommen = false;
        while (!angekommen)
        {
            // Weiterfahren

            // eventuell tanken

            // Stau stehen

            // ...
            angekommen = true;
            // Fahren


        }


        // while(Schleifenbedingung){ Schleifenkörper }
        int zahl = 0;
        while (zahl < 10){
            zahl++;
        }
    }
}
