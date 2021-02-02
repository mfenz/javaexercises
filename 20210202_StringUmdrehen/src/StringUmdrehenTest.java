public class StringUmdrehenTest {
    public static void main(String[] main){
        StringUmdrehenTest t = new StringUmdrehenTest();
        t.testen();
    }

    public void testen(){
        StringUmdrehen umdrehen1 = new StringUmdrehen("abcdefg");
        String umdrehen1Result = umdrehen1.stringUmdrehen();
        // Ausgabe: abcdefg --> gfedcba
        String eingabe = umdrehen1.getEingabe();
        System.out.printf("%s --> %s \n", eingabe, umdrehen1Result);
    }
}
