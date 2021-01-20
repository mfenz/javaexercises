import java.util.Scanner;

public class WasserglasTest {
    // Static: im ganzen Programm nur 1x
    // wird beim Programmstart geladen und initialisiert
    private static int counter = 0;

    // Innerhalb der runden Klammern: Übergabeparamter
    // Übergabeparamter: String Array mit Variablennamen args
    public static void main(String[] args) {
        // legt ein neues Objekt der Klasse WasserglasTest an
        WasserglasTest objekt = new WasserglasTest();
        // ruft für dieses Objekt die Methode testen() auf
        objekt.testen();
    }

    // Innerhalb der runden Klammern: Übergabeparamter
    public void testen(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte den Durchmesser eingeben:");
        float durchmesser = scanner.nextFloat();
        System.out.println("Bitte die Höhe eingeben:");
        float hoehe = scanner.nextFloat();

        // new --> Erstelle ein neues Objekt der Klasse Wasserglas
        Wasserglas wasserglas = new Wasserglas(durchmesser / 2.0f, hoehe);
        // Methode getVolumen() für das zuvor erstellte Wasserglas aufrufen
        // Rückgabewert auf die lokale Variable volumen speichern
        float volumen = wasserglas.getVolumen();
        System.out.println("Volumen: " + volumen);
    }
    

}
