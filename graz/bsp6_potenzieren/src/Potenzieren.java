import java.util.Scanner;

public class Potenzieren {
    public void rechnen(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Basis eingeben:");
        int basis = scanner.nextInt();
        System.out.println("Exponent eingeben:");
        int exponent = scanner.nextInt();

        // Variante 1
        int ergebnis = (int)Math.pow(basis, exponent);

        // Variante 2
        ergebnis = 1;
        for(int i = 0; i < exponent; i++){
            ergebnis = ergebnis * basis;
        }

        // Rechenweg ausgeben
        for(int i = 0; i < exponent; i++){
            System.out.print(basis);
            if(i != exponent-1){
                // wenn man noch nicht beim letzten Schleifendurchgang ist,
                // dann * ausgeben
                System.out.print(" * ");
            }
        }
        System.out.print(" = " + ergebnis);
    }
}
