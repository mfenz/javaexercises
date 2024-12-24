public class Main {
    public static void main(String[] args) {
        // x++ zuerst lesen, dann erhöhen
        // ++x zuerst erhöhen, dann lesen
        int x = 0;
        System.out.println(x++); // Ausgabe: 0

        x = 0;
        System.out.println(++x); // Ausgabe: 1

        x = 0;
        int y = x++; // Welchen Wert hat y? Welchen Wert hat x?
        System.out.println("x: " + x);
        System.out.println("y: " + y);

        int i = 0;
        String[] name = {"A", "B", "C"};
        System.out.println(name[i++]); // A, i wird 1
        System.out.println(name[i++]); // B, i wird 2
        System.out.println(name[i]); // C, i bleibt 2

        i = 0;
        // ++i zuerst erhöhen, dann verwenden
        System.out.println(name[++i]); // B, i wird 1
        System.out.println(name[++i]); // C, i wird 2
        System.out.println(name[++i]); //
    }
}