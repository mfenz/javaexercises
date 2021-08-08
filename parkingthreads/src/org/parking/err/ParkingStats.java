package org.parking.err;

public class ParkingStats {

    private ParkingCash cash;

    private int numberCars;

    public ParkingStats(ParkingCash cash) {
        this.cash = cash;
    }

    public void enter(){
        numberCars++;
    }

    public void leave(){
        numberCars--;
        cash.vehiclePay();
    }

    public int getNumberCars() {
        return numberCars;
    }
}
