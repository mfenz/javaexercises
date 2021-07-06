package at.cb.kassabon;

public class Kassabon {


    /**
     * public: Diese Methode ist auch von anderen Klassen aus aufrufbar
     * static: gehört direkt zu einer Klasse (nicht zum Objekt einer Klasse)
     * void: Diese Methode gibt keinen Wert zurück
     * main: Methodenname
     * ( ... ): Übergabeparameter - Werte (in Variablen) die in die Methode hineinkommen
     * (String[] args): Ein String-Array wird beim Aufruf der Methode main mitgegeben
     * {  }: Methodenkörper (hier kommen Anweisungen rein)
     */
    public static void main(String[] args){
        // Objekt der Klasse Kassabon erstellen
        // Klassenname variablenname = new Klassenname();
        Kassabon k = new Kassabon();
        // Methode definition aufrufen
        k.definition();
    }

    /**
     * public: Sichtbarkeit, wir können auch in anderen Klassen die Methode definition aufrufen
     * void: Rückgabetyp (void heißt es gibt keinen Rückgabetyp und keine Rückgabe)
     * definition: Methodenname
     * (): Übergabeparameter (diese Methode hat keine Übergabeparameter)
     */
    public void definition(){
        String p1Name = "Wurst";
        double p1Einzelpreis = 1.59;
        int p1Stueckzahl = 3;

        String p2Name = "Brot";
        double p2Einzelpreis = 2.50;
        int p2Stueckzahl = 2;

        String p3Name = "Joghurt";
        double p3Einzelpreis = 0.7;
        int p3Stueckzahl = 60;

        print(p1Name, p1Einzelpreis, p1Stueckzahl);
        print(p2Name, p2Einzelpreis, p2Stueckzahl);
        print(p3Name, p3Einzelpreis, p3Stueckzahl);
    }

    /**
     * public: Sichtbarkeit (von allen Klassen aus sichtbar)
     * void: Methode gibt keinen Wert zurück
     * print: Name der Methode, beschreibt die Tätigkeit innerhalb der Methode
     * (String produktName, double einzelpreis, int stueckzahl): Übergabeparameter (3 Parameter)
     */
    public void print(String produktName, double einzelpreis, int stueckzahl){
        double summe = einzelpreis * stueckzahl;
        // Wasser         6 x  0.99      5.93 EUR
        System.out.printf("%-20s %2d x %6.2f %6.2f EUR %n", produktName, stueckzahl, einzelpreis, summe);
    }
}
