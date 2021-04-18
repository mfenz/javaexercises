package at.cb.world.model;

import at.cb.world.ui.RacingUi;

public class Car extends Vehicle{

    public Car(String brand, String model, double acceleration0toMaxSpeedSec,
               double maxSpeed) {
        super(brand, model, acceleration0toMaxSpeedSec, maxSpeed);
    }

    public void draw(){
        super.draw();
        System.out.println(RacingUi.carImage.indent(getDistanceOffset()));
    }

}
