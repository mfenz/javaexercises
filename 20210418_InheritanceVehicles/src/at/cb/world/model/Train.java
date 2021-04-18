package at.cb.world.model;

import at.cb.world.ui.RacingUi;

public class Train extends Vehicle{
    public Train(String brand, String model, double acceleration0toMaxSpeedSec,
                 double maxSpeed) {
        super(brand, model, acceleration0toMaxSpeedSec, maxSpeed);
    }

    public void draw(){
        super.draw();
        System.out.println(RacingUi.trainImage.indent(getDistanceOffset()));
    }
}
