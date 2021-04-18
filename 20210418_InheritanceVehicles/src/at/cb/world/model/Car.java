package at.cb.world.model;

import at.cb.world.ui.RacingUi;

import java.util.Random;

public class Car extends Vehicle {

    protected CarStatus carStatus = CarStatus.OK;

    public Car(String brand, String model, double acceleration0toMaxSpeedSec,
               double maxSpeed) {
        super(brand, model, acceleration0toMaxSpeedSec, maxSpeed);
    }

    public void move() {
        Random random = new Random();
        int prob = random.nextInt(100 - 0) + 0;
        if (carStatus == CarStatus.ARRESTED) {

        } else if (currentSpeedMs >= kmPerHourToMetersPerSecond(130) && prob <= 10) {
            carStatus = CarStatus.ARRESTED;
            currentSpeedMs = 0;
        } else {
            super.move();
        }
    }

    public void draw() {
        super.draw();
        if(carStatus == CarStatus.ARRESTED){
            System.out.println(RacingUi.policeStopImage.indent(getDistanceOffset()));
        } else {
            System.out.println(RacingUi.carImage.indent(getDistanceOffset()));
        }
    }

    protected enum CarStatus {
        OK,
        ARRESTED,
    }

}
