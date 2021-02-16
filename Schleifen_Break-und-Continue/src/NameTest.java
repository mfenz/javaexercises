public class NameTest {
    public static void main(String[] args) {
        NameTest test = new NameTest();
        test.testen();
    }

    public void testen(){
        Name n1 = new Name("Hans");
        String umgedreht = n1.umdrehen();
        System.out.println(n1.getName() + " umgedreht: " + umgedreht);


        Name n2 = new Name("Hubert");
        umgedreht = n2.umdrehen();
        System.out.println(n2.getName() + " umgedreht: " + umgedreht);
    }
}
