package at.cb.world;

import at.cb.world.bl.RacingBl;
import at.cb.world.model.Car;
import at.cb.world.model.MotorYacht;


public class World {
    public static void main(String[] args)  {
        RacingBl bl = new RacingBl();
        bl.addVehicles();
        bl.race();
    }
}
