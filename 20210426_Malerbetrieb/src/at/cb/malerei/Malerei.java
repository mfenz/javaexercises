package at.cb.malerei;

import at.cb.malerei.bl.MalereiBl;

import java.util.Scanner;

public class Malerei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            MalereiBl bl = new MalereiBl();
            bl.addFlaechen();
            bl.printBenoetigteFarbMenge();
        }while (!scanner.nextLine().equals("exit"));
    }
}
