import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {

        // Bedingung: bool'scher Ausdruck
//        if(BEDINGUNG){
//
//        }

        int a = 2;
        switch (a){
            case 1: /* ..CODE.. */ break;
            case 2: /* ..CODE.. */ break;
            case 3: /* ..CODE.. */ break;
        }

        if(a == 1){
            /* ..CODE.. */
        } else if(a == 2){
            /* ..CODE.. */
        } else if(a == 3){
            /* ..CODE.. */
        }



        // Switch-Case:
//        int z = 9000;
//        switch(z){
//            case 0:
//                System.out.println("Z ist null!"); break;
//            case 1:
//                System.out.println("Z ist eins!");
//            case 2:
//                System.out.println("Z ist zwei!"); break;
//            case 1000:
//                System.out.println("Z ist tausend!"); break;
//            default:
//                System.out.println("Wir sind im default-case");
//        }

        System.out.println(
                "Eingabe erforderlich: y zum Fortfahren, n zum Beenden:");
        Scanner scanner = new Scanner(System.in);
        String eingabe = scanner.nextLine();

        switch(eingabe){
            case "y": {
                System.out.println("Bitte einen Wert zwischen 1 und 10 eingeben:");
                int zahl = scanner.nextInt();
                if(zahl < 1 || zahl > 10){
                    System.out.println("Ungültige Eingabe!");

                } else {
                    System.out.println("fortfahren ... ");
                    switch (zahl){
                        case 5: break;
                        case 10: break;
                    }
                }
                break;
            }
            case "n": {
                System.out.println("Danke auf Wiedersehen!");
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Bitte korrekte Eingaben machen. Danke.");
            }
        }
    }
}
