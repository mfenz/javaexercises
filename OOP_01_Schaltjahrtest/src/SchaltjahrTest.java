public class SchaltjahrTest {

    public static void main(String[] args) {
        // Neues Objekt erstellen
        SchaltjahrTest test = new SchaltjahrTest();
        test.testen();
    }
    public void testen(){
        // Zwei Schaltjahre erstellen
        Schaltjahr s1 = new Schaltjahr(2000);
        Schaltjahr s2 = new Schaltjahr(2021);
        // Testergebnis ausgeben
        System.out.println(s1.getJahr() + ": " + s1.isSchaltjahr());
        System.out.println(s2.getJahr() + ": " + s1.isSchaltjahr());
    }
}
