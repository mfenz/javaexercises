public class Main {
    public static void main(String[] args) {
        // Was benötigt man um eine Methode in einer anderen Klasse aufrufen zu können?
        // --> zuerst ein Objekt der Klasse erzeugen in der die Methode enthalten ist
        SchereSteinPapierBL bl = new SchereSteinPapierBL();
        // für das Objekt, welches in der Variable "bl" gespeichert wurde, die Methode play() aufrufen
        bl.play();
    }
}