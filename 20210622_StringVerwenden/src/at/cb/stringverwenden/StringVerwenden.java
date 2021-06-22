package at.cb.stringverwenden;

public class StringVerwenden {
    public static void main(String[] args){
        // Objekt erstellt
        StringVerwenden s = new StringVerwenden();
        // Methode des Objekts aufgerufen
        s.texte();
    }

    public void texte(){
        String txt1 = "Hello World";
        String txt2 = "Good Night";

        System.out.println("Variable deklariert und initialisiert");
        System.out.println("txt1:");
        System.out.println(txt1);
        System.out.println("txt2:");
        System.out.println(txt2);

        // Strings zusammenfügen
        String zusammen = txt1 + txt2;
        System.out.println("Beide Strings zusammengefügt:");
        System.out.println(zusammen);

        // String1 mit dem Wert von String2 überschreiben
        // string1 = string2
        txt1 = txt2;

        System.out.println("String 1 mit String 2 überschrieben:");
        System.out.println("txt1:");
        System.out.println(txt1);
        System.out.println("txt2:");
        System.out.println(txt2);
    }
}
