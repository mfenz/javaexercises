package at.cb.stringmethoden;

public class StringMethoden {
    public static void main(String[] args) {
        // Objekt der Klasse StringMethoden erzeugen
        // Objekt mit new Klassenname(); erzeugen
        StringMethoden strMeth = new StringMethoden();
        // Für das Objekt die stringRueckwaerts() Methode aufrufen
        strMeth.stringRueckwaerts();
        // findFileExtension() aufrufen
        strMeth.findFileExtension();

        strMeth.grosseAnfangsbuchstaben();
    }

    public void stringRueckwaerts(){
        /**
         * Input:
         * Hallo Welt
         * Output:
         * tleW ollaH
         */
        String text = "Schönen guten Morgen!";
        // Aus wie vielen Zeichen besteht der String?
        // .length() gibt die Anzahl der Zeichen im String zurück
        // "Hello World".length() --> 11
        int anzahlZeichen = text.length();

        // text.charAt(0) gibt mir das erste Zeichen im String
        char erstes = text.charAt(0); // H
        char letztes = text.charAt(text.length() - 1); // d

        System.out.printf("%s => ", text);

        // for(INIT; SCHLEIFENBEDINGUNG; VERÄNDERUNG) {S. Körper}
        for(int i = text.length() - 1; i >= 0; i--){
            // mit charAt(i) wird ein einzelner Buchstabe herausgeholt
            // Buchstabe mit Index i aus String holen
            char buchstabe = text.charAt(i);
            // Ausgabe des Buchstabens ohne Zeilenumbruch
            System.out.print(buchstabe);
        }
        System.out.println();
    }

    public void findFileExtension(){
        String filename = "img_43234.jpg";
        // Wo befindet sich ein bestimmtes Zeichen im String?
        int indexOfPoint = filename.lastIndexOf(".");
        // wenn indexOfPoint negativ, dann wurde Punkt nicht gefunden
        if(indexOfPoint < 0){
            System.out.printf("Dateiendung für %s konnte nicht " +
                    "gefunden werden %n", filename);
        } else {
            // substring liefert einen (Teil-) Ausschnitt aus einem String
            // hier: alle Zeichen ab dem Index indexOfPoint
            String extension = filename.substring(indexOfPoint);
            switch (extension) {
                case "jpg":
                    // check if jpg
                    break;
                case "png":
                    // check if png ...
                    break;
            }
            System.out.printf("Die Dateiendung von %s ist %s %n", filename, extension);
        }
    }

    public void grosseAnfangsbuchstaben(){
        String text = "jeden sonntag gibt es gemüse";
        // 1) String anhand der Leerzeichen trennen
        // .split() liefert ein Array von Strings zurück
        String woerter[] = text.split(" ");

        //
        StringBuilder sb = new StringBuilder();

        // Aus dem Array jedes Wort herausholen
        for(int i = 0; i < woerter.length; i++){
            String wort = woerter[i];
            // das erste Zeichen aus String holen, daraus String machen, dann toUpperCase()
            String erstesZeichen = (wort.charAt(0) + "").toUpperCase();
            // erstes Zeichen um StringBuilder hinzufügen
            sb.append(erstesZeichen);
            // Den Rest des Worts zum StringBuilder hinzufügen
            sb.append(wort.substring(1)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
