package at.cb.display.ifaces;

/**
 * Zwei Zeilen Display kann pro Zeile 30 Zeichen angeigen
 */
public class ZweiZeilenDisplay implements Darstellbar{
    @Override
    public void darstellen(String str) {
        // wenn str > 30 Zeichen, dann Zeilenumbruch
        // wenn str > 60 Zeichen, dann Rest abschneiden

        // Math.min(a, b) <-- Gibt a oder b zurück, gibt den
        // kleineren der beiden Werte zurück
        // substring(startIndex, endIndex) <-- endIndex exklusive!!
        // str ist dann höchstens 60 Zeichen lang
        str = str.substring(0, Math.min(60, str.length()));

        if(str.length() <= 30){
            // Kein Zeilenumbruch notwendig
            System.out.println(str);
        } else {
            // ersten 30 Zeichen aus
            System.out.println(str.substring(0, 30));
            // letzten x Zeichen ausgeben, bei 30 starten
            System.out.println(str.substring(30));
        }
    }
}
