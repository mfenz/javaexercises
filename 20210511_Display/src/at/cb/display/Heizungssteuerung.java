package at.cb.display;

import at.cb.display.ifaces.Darstellbar;
import at.cb.display.ifaces.Tablet;
import at.cb.display.ifaces.ZweiZeilenDisplay;

import java.util.Scanner;

public class Heizungssteuerung {

    // Instanzvariable, Datentyp vom Interface
    // später dann ZweiZeilenDisplay oder Tablet zuweisen
    // --> Objekt zuweisen, dass das Interface Darstellbar implementiert
    private Darstellbar display;

    public static void main(String[] args) {
        // Aktuelle Raumtemperatur
        // Soll-Temperatur
        // 2 Zeilen 30 Spalten
        // 5 Zeilen 60 Spalten
        Heizungssteuerung heizungssteuerung = new Heizungssteuerung();
        heizungssteuerung.hauptmenue();
    }

    public Heizungssteuerung(){
        this.display = new ZweiZeilenDisplay();
    }

    public void hauptmenue(){
        Scanner scanner = new Scanner(System.in);

        // Display wechseln
        // --> ZweiZeilenDisplay
        // --> Tablet
        // Aktuelle Temperaturen ausgeben
        System.out.println("--- Hauptmenü ---");
        while (true){
            System.out.println("-----------------");
            System.out.println("2z : Zwei Zeilen Display verwenden");
            System.out.println("tablet : Tablet verwenden");
            System.out.println("ausgabe : Heizdaten ausgeben");
            switch (scanner.nextLine()){
                case "2z":
                    setZweiZeilenDisplay();
                    break;
                case "tablet":
                    setTablet();
                    break;
                case "ausgabe":
                    ausgabe();
                    break;
                default:
                    System.out.println("Ungültige Eingabe!");
            }
        }
    }

    public void setZweiZeilenDisplay(){
        // Objekt der Klasse ZweiZeilenDisplay zuweisen
        display = new ZweiZeilenDisplay();
    }

    public void setTablet(){
        // Objekt der Klasse Tablet zuweisen
        display = new Tablet();
    }

    public void ausgabe(){
        // Komplexe Instanzvariablen sind null wenn nicht initialisiert
        if(display == null){
            System.out.println("Bitte zuerst ein Display wählen!");
            return;
        }
        String ausgabe = "Im Haus sind angenehme 25 °C und das Wetter ist schön." +
                "Die Soll-Temperatur beträgt warme 22 ° C und in einer Stunde wird" +
                "die Klimaanlage aktiviert.";
        // Methode aufrufen
        display.darstellen(ausgabe);
    }


}
