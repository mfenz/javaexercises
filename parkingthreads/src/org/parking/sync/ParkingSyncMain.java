package org.parking.sync;

public class ParkingSyncMain {
    public static void main(String[] args) {
        ParkingCash cash = new ParkingCash();
        ParkingStats stats = new ParkingStats(cash);

        System.out.println("Parking Simulator");

        int numberSensors = 2 * Runtime.getRuntime().availableProcessors();
        Thread threads[] = new Thread[numberSensors];
        for(int i = 0; i < threads.length; i++){
            Sensor sensor = new Sensor(stats);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[i] = thread;
        }

        for(int i = 0; i < threads.length; i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Number of sensors: %d %n", numberSensors);
        System.out.printf("Number of cars: %d %n", stats.getNumberCars());
        cash.close();
    }
}
