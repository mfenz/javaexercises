package at.cb.world.model;

import at.cb.world.ui.RacingUi;

public class MotorYacht extends Boat{

    public MotorYacht(String brand, String model,
                      double acceleration0toMaxSpeedSec,
                      double maxSpeed) {
        super(brand, model, acceleration0toMaxSpeedSec, maxSpeed);
    }

    public void draw(){
        super.draw();
        System.out.println(RacingUi.motorYachtImage.indent(getDistanceOffset()));
    }
}
