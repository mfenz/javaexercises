package org.parking.blocksync;

import java.util.concurrent.TimeUnit;

public class Sensor implements Runnable {
    private ParkingStats stats;

    public Sensor(ParkingStats stats) {
        this.stats = stats;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            stats.enterCar();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stats.enterMotorbike();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stats.leaveCar();
            stats.leaveMotorbike();
        }
    }
}
