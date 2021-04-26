package at.cb.zahlen;

public class Zahlentraeume {
    public static void main(String[] args) {
        int zahl = 5;
        if(zahl >= 1 && zahl <= 5){
            System.out.println("Die Zahl liegt zwischen 1 und 5");
        } else if(zahl >= 6 && zahl <= 10){
            System.out.println("Die Zahl liegt zwischen 6 und 10");
            if(zahl == 10){
                System.out.println("Jackpot");
            }
        } else if(zahl == 0){
            System.out.println("Die Zahl darf nicht 0 sein");
        } else {
            System.out.println("Die Zahl ist zu groß oder zu klein");
        }

    }
}
