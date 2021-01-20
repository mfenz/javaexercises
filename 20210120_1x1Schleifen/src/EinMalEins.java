public class EinMalEins {
    public static void main(String[] args) {
        for(int i = 1; i <= 10; ++i){
            for(int j = 1; j <= 10; ++j){
                int ergebnis = i * j;
                System.out.printf("%2d x %2d = %2d\n", j, i, ergebnis);
            }
            System.out.println();
        }
    }
}
