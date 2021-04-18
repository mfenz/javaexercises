package at.cb.world.model;

public class Vehicle {
    protected String brand;
    protected String model;
    protected double acceleration0toMaxSpeedSec;
    protected double maxSpeed;
    protected double currentSpeed;

    protected double currentDistance;

    public Vehicle(String brand, String model,
                   double acceleration0toMaxSpeedSec,
                   double maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.acceleration0toMaxSpeedSec = acceleration0toMaxSpeedSec;
        this.maxSpeed = maxSpeed;
    }

    public String getInfo(){
        return String.format("%10s %10s speed: %.2f km/h distance: %.2f", brand, model, currentSpeed, currentDistance);
    }

    public void move() {
        // accelerate until maxSpeed is reached
        // calculate acceleration
        double acceleration = maxSpeed / acceleration0toMaxSpeedSec;
        // accelerate
        currentSpeed += acceleration;

        if (currentSpeed >= maxSpeed) {
            // limit vehicle speed to maxSpeed
            currentSpeed = maxSpeed;
        }
        currentDistance += currentSpeed;
    }

    public void draw() {
        System.out.println(getInfo());
    }

    public int getDistanceOffset(){
        return (int)(currentDistance / 100);
    }

    public double getCurrentDistance() {
        return currentDistance;
    }
}
