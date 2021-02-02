public class FindeDenStringTest {
    public static void main(String[] args){
        //FindeDenStringTest.testen(); --> wenn Methode static wäre!
        FindeDenStringTest test = new FindeDenStringTest();
        test.testen(); // Punkt-Operator um Methode testen() auszuführen
    }

    public void testen(){
        // Neues Objekt der Klasse "FindeDenString" erzeugen
        FindeDenString s1 = new FindeDenString("abcdefgh", 'e');
        // Methode findeDenString() mit dem Punktoperator aufrufen
        s1.findeDenString();

        /**
         * Zeichenkette: "abcdefgh"
         * Zeichen: "z"
         * Ausgabe: "Leider ist dieses Zeichen nicht in dieser Zeichenkette enthalten"
         */
        FindeDenString s2 = new FindeDenString("abcdefgh", 'z');
        s2.findeDenString();
    }
}
