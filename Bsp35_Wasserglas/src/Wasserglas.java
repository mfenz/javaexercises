public class Wasserglas {
    // Instanzvariablen (Daten für das Wasserglas)
    // Attribute
    private float radius;
    private float hoehe;

    // Konstruktor: public Klassenname
    // wird beim Erstellen eines neuen Objekts mit "new" aufgerufen
    public Wasserglas(float radius, float hoehe){
        this.radius = radius;
        this.hoehe = hoehe;
    }

    // float : Rückgabetyp (wenn sie fertig ist, gibt sie einen Wert
    // vom Datentyp float zurück
    public float getVolumen(){
        float volumen = (float) (Math.pow(radius, 2) * Math.PI * hoehe);
        // Return: beende die Methode, und gebe den Inhalt der Variable
        // volumen zurück
        return volumen;
    }


}
