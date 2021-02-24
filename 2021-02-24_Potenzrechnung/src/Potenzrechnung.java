public class Potenzrechnung {
    public static void main(String[] args) {

        int a = 3;
        int b = 4;

        int ergebnis = 1;
        int i = 0;
        while (i < b){
            ergebnis = ergebnis * a;
            i++;
        }
        System.out.println(ergebnis);
    }
}
