import java.util.Arrays;
import java.util.Scanner;

public class HighscoreMitSort {
    public static void main(String[] args) {
        int[] highscore = {1000, 953, 832, 765};
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Highscore eingeben:");
            int score = scanner.nextInt();

            int[] newHighscore = new int[highscore.length+1];
            for(int i = 0; i < highscore.length; i++){
                newHighscore[i] = highscore[i];
            }
            // Eingabe am Ende des Arrays einfügen
            newHighscore[newHighscore.length-1] = score;
            highscore = newHighscore;

            // Array zum Schluss sortieren
            Arrays.sort(highscore);

            print(highscore);
        }
    }

    public static void print(int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();
    }
}
