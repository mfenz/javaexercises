package at.cb.race.model;

import at.cb.race.ui.RaceUi;

public class MotorYacht extends Boat{
    public MotorYacht(String brand, String model,
                      double acceleration0toMaxSpeedSec,
                      double maxSpeedKmh, double draft) {
        super(brand, model, acceleration0toMaxSpeedSec, maxSpeedKmh, draft);
    }

    public void draw(){
        super.draw();
        System.out.println(RaceUi.motorYachtImage.indent(getDistanceOffset()));
    }
}
