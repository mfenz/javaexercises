import java.util.Scanner;

public class SummeNZahlen {
    public void berechneSummeNZahlen(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte die Zahl eingeben:");
        int n = scanner.nextInt();

        int sum = 0;

        // gehe mit einer for-Schleife von 1 bis n
        for(int i = 1; i <= n; i++){
            sum += i;
            System.out.print(i);
            if(i != n){
                System.out.print("+");
            }
        }
        System.out.print(" = " + sum);
    }
}
