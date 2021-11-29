package at.cb.s20211122wortanalyse;

import java.util.Scanner;

public class SummeNZahlen {
    public static void main(String[] args) {
        System.out.println("Zahl eingeben:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int sum = 0;

        for(int i = 0; i <= num; i++){
            sum += i;

            System.out.print(i);
            if(i != num){
                System.out.print(" + ");
            } else {
                System.out.print(" = " + sum);
            }
        }
    }
}
