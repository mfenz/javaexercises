package at.cb.world.model;

public class Boat extends Vehicle{

    private double draft;

    protected enum BoatStatus {
        OK,
        SUNK,
    }

    protected BoatStatus boatStatus = BoatStatus.OK;

    public Boat(String brand, String model, double acceleration0toMaxSpeedSec,
                double maxSpeed) {
        super(brand, model, acceleration0toMaxSpeedSec, maxSpeed);
    }


}
