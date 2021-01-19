public class FormatierteAusgabe {
    public static void main(String[] args) {
        // System.out.printf() --> formatierte Ausgabe
        // Wurst       5x  1,19 EUR
        // Käse       15x 51,00 EUR

        String produkt1 = "Wurst";
        String produkt2 = "Käse";
        int anzProdukt1 = 5;
        int anzProdukt2 = 15;
        float einzelpreisProdukt1 = 1.19f;
        float einzelpreisProdukt2 = 51f;

        // %s --> String
        // %d --> int (digit)
        // %f --> float oder double
        System.out.printf("%-20s %2dx %5.2f EUR\n", produkt1, anzProdukt1, einzelpreisProdukt1);
        System.out.printf("%-20s %2dx %5.2f EUR\n", produkt2, anzProdukt2, einzelpreisProdukt2);
    }
}
