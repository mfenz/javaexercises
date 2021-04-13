public class Kassabon {
    public static void main(String[] args) {
        String p1Name = "Wurst";
        double p1Einzelpreis = 13.42;
        int p1Anzahl = 4;

        String p2Name = "Käse";
        double p2Einzelpreis = 0.99;
        int p2Anzahl = 35;

        printPosition(p1Name, p1Anzahl, p1Einzelpreis);
        printPosition(p2Name, p2Anzahl, p2Einzelpreis);
        // %s String
        // %d int
        // %f für float oder double
        // %n neue Zeile
//        System.out.printf("%-15s %3d x %6.2f %n", p1Name, p1Anzahl, p1Einzelpreis);
//        System.out.printf("%-15s %3d x %6.2f %n", p2Name, p2Anzahl, p2Einzelpreis);
    }

    private static void printPosition(String produktName, int anzahl, double einzelpreis){
        System.out.printf("%-15s %3d x %6.2f %n", produktName, anzahl, einzelpreis);
    }
}
