package org.parking.sync;

public class ParkingCash {
    private static final int cost = 2;
    private int cash;

    public void vehiclePay(){
        cash += cost;
    }

    public void close(){
        System.out.println("Good night!");
        int totalAmount = cash;
        cash = 0;
        System.out.printf("The total amount is: %d%n", totalAmount);
    }
}
