package service;

import iface.Displayable;

public class DisplayService {
    public static void display(Displayable displayable){
        String text = displayable.getLabel();
        for(int i = 0; i < 22; ++i){
            System.out.print("*");
        }
        System.out.println();
        System.out.print("*");
        System.out.printf("%-20s", displayable.getLabel());
        System.out.print("*");
        System.out.println();
        for(int i = 0; i < 22; ++i){
            System.out.print("*");
        }
    }
}
