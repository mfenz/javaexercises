public class BreakVerwenden {
    public static void main(String[] args) {
        int i = 0;
        // Endlosschleife?
        while (true){
            System.out.printf("i=%d\n", i);
            if(i == 100){
                // break beendet sofort
                // die Schleife wenn i == 100
                break;
            }
            i += 20;
        }
        System.out.println("Fertig!");
    }
}
