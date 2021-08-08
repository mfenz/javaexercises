package org.parking.sync;

public class ParkingStats {

    private ParkingCash cash;

    private int numberCars;

    public ParkingStats(ParkingCash cash) {
        this.cash = cash;
    }

    public synchronized void enter(){
        numberCars++;
    }

    public synchronized void leave(){
        numberCars--;
        cash.vehiclePay();
    }

    public int getNumberCars() {
        return numberCars;
    }
}
