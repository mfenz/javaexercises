package at.cb.race.model;

public class Boat extends Vehicle{

    protected enum BoatStatus {
        OK,
        SUNK,
    }

    // Tiefgang
    protected double draft;
    protected BoatStatus boatStatus = BoatStatus.OK;

    public Boat(String brand, String model, double acceleration0toMaxSpeedSec,
                double maxSpeedKmh, double draft) {
        super(brand, model, acceleration0toMaxSpeedSec, maxSpeedKmh);
        this.draft = draft;
    }
}
