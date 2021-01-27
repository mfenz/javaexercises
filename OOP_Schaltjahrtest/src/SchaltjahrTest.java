public class SchaltjahrTest {
    public static void main(String[] args) {
        SchaltjahrTest test = new SchaltjahrTest();
        test.testen();
    }

    public void testen(){
        // Objekte erzeugen
        Jahr jahr2008 = new Jahr(2008);
        Jahr jahr2100 = new Jahr(2100);
        Jahr jahr2000 = new Jahr(2000);

        // Objekte testen
        System.out.printf("Jahr: %d Schaltjahr? %s \n", jahr2008.getJahr(), jahr2008.isSchaltjahr());
        System.out.printf("Jahr: %d Schaltjahr? %s \n", jahr2100.getJahr(), jahr2100.isSchaltjahr());
        System.out.printf("Jahr: %d Schaltjahr? %s \n", jahr2000.getJahr(), jahr2000.isSchaltjahr());
    }
}
