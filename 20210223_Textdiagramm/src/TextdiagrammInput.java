public class TextdiagrammInput {
    public static void main(String[] args) {
        TextdiagrammInput ti = new TextdiagrammInput();
        ti.diagrammErstellen();
    }

    /**
     * User Eingabe der Zahl
     * @return eingegebene Zahl
     */
    public int checkInput(){
        // Hier wird die Eingabe gemacht

        // Zahl zwischen 1 und 10 eingeben
        // Todo ...
        int zahl = 6;
        return zahl;
    }

    public void diagrammErstellen(){
        // User-Input liefert uns die Methode checkInput()
        int input = checkInput();

        Textdiagramm tx1 = new Textdiagramm(input);
        tx1.printTextdiagramm();
    }


}
