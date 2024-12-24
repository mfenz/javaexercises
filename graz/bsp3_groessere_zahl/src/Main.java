import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte die erste Zahl eingeben:");
        int z1 = scanner.nextInt();
        System.out.println("Bitte die zweite Zahl eingeben:");
        int z2 = scanner.nextInt();

        if(z1 > z2){
            System.out.println(z1);
        } else if(z2 > z1){
            System.out.println(z2);
        } else {
            System.out.println("Beide Zahlen sind gleich");
        }
    }
}