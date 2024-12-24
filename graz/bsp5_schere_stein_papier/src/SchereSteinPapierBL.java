import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SchereSteinPapierBL {

    public void play(){
        List<String> choices = new ArrayList<>();
        choices.add("Schere");
        choices.add("Stein");
        choices.add("Papier");

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int counterComputer = 0;
        int counterMensch = 0;

        for(int i = 0; i < 5; i++){
            // Wie spielt Computer?
            int computerRandomIndex = random.nextInt(3); // von 0 - 2
            String c = choices.get(computerRandomIndex);

            // Wie spielt Mensch?
            System.out.println("Schere, Stein, Papier?");
            String u = scanner.nextLine();

            // %s: Platzhalter für eine String-Variable
            // %n: macht einen Zeilumbruch
            System.out.printf("Computer: %s, Mensch: %s%n", c, u);
            if(c.equalsIgnoreCase(u)){
                System.out.println("Unentschieden!");
            } else if((c.equals("Stein") && u.equals("Papier"))
                    || (c.equals("Papier") && u.equals("Schere"))
                    || (c.equals("Schere") && u.equals("Stein"))) {
                System.out.println("Mensch gewinnt!");
                counterMensch++;
            } else {
                System.out.println("Computer gewinnt!");
                counterComputer++;
            }
        }

        // nach den fünf Spielzügen ermitteln wer gewonnen hat
        if(counterMensch == counterComputer){
            System.out.println("Unentschieden!");
        } else if(counterMensch > counterComputer){
            System.out.println("Mensch hat gewonnen!");
        } else {
            System.out.println("Computer hat gewonnen!");
        }
        System.out.printf("Der Computer hat %dx gewonnen, der Mensch hat %dx gewonnen. %n",
                counterComputer,
                counterMensch);

    }
}
