import java.util.Scanner;

public class IfAndSwitch {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("Bitte Wert eingeben zwischen 1 und 10:");
        int wert = 5; // scanner.nextInt();
        // true && true --> true
        if(wert <= 5 && wert >=1){
            System.out.println("Die Zahl liegt zwischen 1 und 5");
        } else if(wert > 5 && wert <= 10){
            System.out.println("Die Zahl liegt zwischen 6 und 10");
            if(wert == 10){
                System.out.println("Jackpot --> Wenn die Zahl gleich 10 ist");
            }
        }
        else if(wert == 0){
            System.out.println("Die Zahl darf nicht 0 sein");
        } /*else {
            System.out.println("Die Zahl ist zu groß oder klein");
        }*/
    }
}
