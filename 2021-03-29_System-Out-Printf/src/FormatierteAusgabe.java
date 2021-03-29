public class FormatierteAusgabe {
    public static void main(String[] args) {
        String p1Name = "Wurst";
        int p1Anz = 11;
        double p1Ep = 444.2;
        FormatierteAusgabe.printPosition(p1Name, p1Anz, p1Ep);

        String p2Name = "Käse";
        int p2Anz = 1;
        double p2Ep = 2.3;
        FormatierteAusgabe.printPosition(p2Name, p2Anz, p2Ep);
    }

    private static void printPosition(String produktName, int anzahl,
                                      double einzelpreis) {
        System.out.printf("%-15s %2d x %6.2f %10.2f EUR %n",
                produktName, anzahl, einzelpreis, anzahl * einzelpreis);
    }
}
