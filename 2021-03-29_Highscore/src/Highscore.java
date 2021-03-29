import java.util.Scanner;

public class Highscore {
    public static void main(String[] args) {
        Highscore highscore = new Highscore();
        highscore.testen();
    }

    public void testen(){
        Scanner scanner = new Scanner(System.in);

        int[] highscore = {1000, 953, 832, 765};


        while (true){
            System.out.println("Highscore eingeben:");
            int score = scanner.nextInt();

            boolean inserted = false;
            int[] newHighscore = new int[highscore.length+1];
            int iNewHighscore = 0;
            for(int i = 0; i < highscore.length; i++){
                if(score >= highscore[i] && !inserted){
                    newHighscore[iNewHighscore] = score;
                    iNewHighscore++;
                    inserted = true;
                }
                newHighscore[iNewHighscore] = highscore[i];

                iNewHighscore++;
            }
            highscore = newHighscore;
            print(highscore);
        }
    }

    public void print(int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();
    }
}
