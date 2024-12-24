import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte eine Zahl eingeben:");
        int zahl = scanner.nextInt();

        if(zahl == 0){
            System.out.println("Die Zahl darf nicht 0 sein");
        } else if(zahl >= 1 && zahl <= 5){
            System.out.println("Die Zahl liegt zwischen 1 und 5");
        } else if(zahl >= 6 && zahl <= 10){
            System.out.println("Die Zahl liegt zwischen 6 und 10");
            if(zahl == 10){
                System.out.println("Jackpot");
            }
        } else {
            System.out.println("Die Zahl ist zu groß oder zu klein");
        }

    }
}