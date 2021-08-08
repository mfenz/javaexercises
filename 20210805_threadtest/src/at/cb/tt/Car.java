package at.cb.tt;

import java.util.concurrent.ThreadLocalRandom;

public class Car implements Runnable{
    private String make;
    private int speed;
    public Car(String make) {
        this.make = make;
    }
    @Override
    public void run() {
        while (speed < 5){
            System.out.printf("%s fährt %d km/h!%n", make, speed);
            speed += ThreadLocalRandom.current().nextInt(4)+1;
        }
        System.out.printf("%s ist im Ziel!%n", make);
    }
}
