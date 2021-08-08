package org.parking.blocksync;

public class ParkingStats {

    private ParkingCash cash;

    private int numberCars;
    private int numberMotorbikes;

    private Object controlCars = new Object();
    private Object controlMotorbikes = new Object();

    public ParkingStats(ParkingCash cash) {
        this.cash = cash;
    }

    public void enterCar(){
        synchronized (controlCars){
            numberCars++;
        }
    }

    public void enterMotorbike(){
        synchronized (controlMotorbikes){
            numberMotorbikes++;
        }
    }

    public void leaveCar(){
        synchronized (controlCars){
            numberCars--;
        }
        cash.vehiclePay();
    }

    public void leaveMotorbike(){
        synchronized (controlMotorbikes){
            numberMotorbikes--;
        }
        cash.vehiclePay();
    }

    public int getNumberCars() {
        return numberCars;
    }
}
