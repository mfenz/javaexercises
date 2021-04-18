package at.cb.world.model;

public class Vehicle {
    protected String brand;
    protected String model;
    protected double acceleration0toMaxSpeedSec;
    protected double maxSpeedMs;
    protected double currentSpeedMs;

    protected double currentDistanceMeter;

    public Vehicle(String brand, String model,
                   double acceleration0toMaxSpeedSec,
                   double maxSpeedKmh) {
        this.brand = brand;
        this.model = model;
        this.acceleration0toMaxSpeedSec = acceleration0toMaxSpeedSec;
        this.maxSpeedMs = kmPerHourToMetersPerSecond(maxSpeedKmh);
    }

    public String getInfo(){
        return String.format("%-10s %-20s speed: %6.2f km/h distance: %6.2f m", brand, model,
                metersPerSecondToKmPerHour(currentSpeedMs), currentDistanceMeter);
    }

    public void move() {
        // accelerate until maxSpeed is reached
        // calculate acceleration
        double acceleration = maxSpeedMs / acceleration0toMaxSpeedSec;
        // accelerate
        currentSpeedMs += acceleration;

        if (currentSpeedMs >= maxSpeedMs) {
            // limit vehicle speed to maxSpeed
            currentSpeedMs = maxSpeedMs;
        }
        currentDistanceMeter += currentSpeedMs;
    }

    public void draw() {
        System.out.println(getInfo());
        for(int i = 0; i < getDistanceOffset(); i++){
            System.out.print("_");
        }
        System.out.println();
    }

    public int getDistanceOffset(){
        return (int)(currentDistanceMeter / 100);
    }

    public double getCurrentDistanceMeter() {
        return currentDistanceMeter;
    }

    public static double kmPerHourToMetersPerSecond(double kmph){
        return kmph / 3.6;
    }

    public static double metersPerSecondToKmPerHour(double mph){
        return mph * 3.6;
    }
}
