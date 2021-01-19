import java.util.Scanner;

public class IfAndSwitch {
    public static void main(String[] args) {
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

        if((wert <= 5 && wert >= 10)){
            if(wert != 0){

            }
            if(wert == 0){

            }
            if(wert % 2 == 0){
                // gerade Zahl
            }
            // % --> Modulo Operator --> Rest der Division
            if(wert % 2 != 0){

            }
        }

        System.out.println("Switch Test");

        wert = 8;
        switch(wert)
        {
            case 1:
                System.out.println("1!"); break;
            case 2:
                System.out.println("2!");
            case 3:
                System.out.println("3!");
            case 4:
                System.out.println("4!");
            case 5:
                System.out.println("Die Zahl liegt zwischen 1 und 5!");
                break;
            case 6:
            case 7:
            case 9:
            case 10:
                System.out.println("Die Zahl liegt zwischen 1 und 10!");
            default:
                System.out.println("Default Case für die Zahl " + wert);

        }

        System.out.println("Nach dem Switch!");
        // nach dem Switch


        String obst = "apfel";
        switch (obst){
            case "Apfel":
            case "Birne":
                System.out.println(obst); break;
            default:
                System.out.println("Kein Obst!");
        }

    }
}
