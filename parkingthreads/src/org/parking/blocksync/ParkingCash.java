package org.parking.blocksync;

public class ParkingCash {
    private static final int cost = 2;
    private int cash;

    public synchronized void vehiclePay(){
        cash += cost;
    }

    public void close(){
        System.out.println("Good night!");
        int totalAmount;
        synchronized (this){
            totalAmount= cash;
            cash = 0;
        }
        System.out.printf("The total amount is: %d%n", totalAmount);
    }
}
