public class Rechner {

    public static void main(String[] args){
        // Variable deklarieren
        // datentyp variablenname;
        int z1;
        // Variable z1 initialisieren
        // Initialisierung mit =
        z1 = 1000;
        // Bei der Ausgabe auf die Variable
        // z1 referenzieren
        System.out.println(z1);
        // Zahl 1: 1000
        System.out.println("Zahl 1: " + z1 + " Fertig");

        // Variable z2 deklarieren und gleichzeitig
        // initialisieren
        int z2 = 6000;

        // Kommazahlen Datentyp: float
        // Deklaration von einer float-Variable
        // datentyp variablenname
        float kommaZahl1 = 1000.9f;
        float kommaZahl2 = 6000.0f;
        float kommaDivision = kommaZahl1 / kommaZahl2;
        System.out.println(kommaDivision);

        // Texte: Datentyp String
        String name = "Vorname";
        String nachname = "Nachname";
        String vollerName = name + " " + nachname;
        System.out.println(name);

        name = "Name überschrieben";
        System.out.println(name);

    }
}
