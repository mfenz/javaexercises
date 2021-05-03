import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MinimumInListe {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        while (true){
            try {
                System.out.println("Bitte eine Zahl eingeben:");
                int zahl = scanner.nextInt();
                System.out.println("Die Zahl " + zahl + " wurde eingegeben");

                Integer x = null;
                int result = x + 5;

                break;
            } catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("Ungültige Eingabe: " + e.getMessage());
                e.printStackTrace();
            } catch (NullPointerException e){
                System.out.println("oje nullpointer!");
            } catch (Exception e){
                System.out.println("Fehler: " + e.getMessage());
            }
        }
        System.out.println("danach");




//        boolean verheiratet = false;
//
//        String text = verheiratet ? "ja!" : "nein ...";
//        text = (5 < 3) ? "a" : "b";
//
//        System.out.printf("Ich bin %sverheiratet", verheiratet? "" : "nicht ");
//
//        System.out.println(text);
//
//        List<Integer> zahlen = List.of(5, 8, 9, 2, 55, 1, 4);
//
//        int smallest = zahlen.get(0);
//        for(int i = 0; i < zahlen.size(); i++){
//            if(zahlen.get(i) < smallest){
//                smallest = zahlen.get(i);
//            }
//        }
//        System.out.printf("Die kleinste Zahl ist %d %n", smallest);
    }
}
