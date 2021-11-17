import java.util.Scanner;

public class EingabeProgramm {
    public static void main(String[] args) {
        // Objekt der Klasse EingabeProgramm erzeugen
        EingabeProgramm prog = new EingabeProgramm();
        // Methode eingabe() aufrufen
        prog.addition();
    }

    // Objekt der Klasse Scanner erzeugen
    Scanner scanner = new Scanner(System.in);

    /**
     * Methode Eingabe liest zwei Zahlen ein und gibt sie aus
     */
    public void eingabe(){
        System.out.println("Erste Zahl eingeben:");
        // Auf die Eingabe der ersten Zahl warten
        int a = scanner.nextInt();
        System.out.println("Zweite Zahl eingeben:");
        // Auf die Eingabe der zweiten Zahl warten
        int b = scanner.nextInt();

        // Ausgabe der zuvor eingegebenen Werte
        System.out.println("a: " + a + " b: " + b);
    }

    public void addition(){
        System.out.println("Erste Zahl eingeben:");
        int a = scanner.nextInt();
        System.out.println("Zweite Zahl eingeben:");
        int b = scanner.nextInt();

        System.out.printf("%d + %d = %d%n", a, b, a+b);
        System.out.printf("%d - %d = %d%n", a, b, a-b);
        System.out.printf("%d * %d = %d%n", a, b, a*b);
        System.out.printf("%d / %d = %d%n", a, b, a/b);
    }
}
