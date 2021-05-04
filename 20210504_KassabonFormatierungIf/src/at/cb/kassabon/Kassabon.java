package at.cb.kassabon;

public class Kassabon {
    public static void main(String[] args) {
        String p1Name = "Wurst";
        int p1Anzahl = 1;
        double p1Einzelpreis = 4.2;
        double p1Teilsumme = p1Anzahl * p1Einzelpreis;

        String p2Name = "Käse";
        int p2Anzahl = 13;
        double p2Einzelpreis = 12.32;
        double p2Teilsumme = p2Anzahl * p2Einzelpreis;

        double geldtasche = 500;
        double gesamtPreis = p1Teilsumme + p2Teilsumme;
        double retour = geldtasche - gesamtPreis;

        // <Produktname> <Anz> x <Einzelpr.>  <Teilsumme> EUR
        // Wurst 	1 x  4,20	 4,20 EUR
        // Käse    13 x 12,32	 2,30 EUR

        // if(Bedingung)
        if(gesamtPreis <= geldtasche){
            // System.out.printf("FORMATIERUNG", wert1, wert2, wert3, ... )
            // %s String
            // %d int
            // %f double oder float
            // %n macht einen Zeilenumbruch
            // %.2f <-- 2 Nachkommastellen
            // 4 Vorkommastellen: 2 Nachkommastellen + 1 Komma = 3 Stellen + 4 Vorkommastellen = %7.2f
            // %3d <-- mindestens 3 Stellen (mit Leerzeilen auffüllen)
            System.out.printf("%-15s %3d x %7.2f %7.2f EUR %n", p1Name, p1Anzahl, p1Einzelpreis, p1Teilsumme);
            System.out.printf("%-15s %3d x %7.2f %7.2f EUR %n", p2Name, p2Anzahl, p2Einzelpreis, p2Teilsumme);
            System.out.println("-----------------------------------------");
            System.out.printf("%-15s %21.2f EUR%n", "Summe", gesamtPreis);
            System.out.printf("%-15s %21.2f EUR%n", "Retourgeld", retour);
        }
        else {
            // wird ausgeführt wenn das verherige if nicht zutrifft
            System.out.println("Sie haben zu wenig Geld!");
        }

    }
}
