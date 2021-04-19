package at.cb.race.model;

public class Car extends Vehicle{
    public Car(String brand, String model, double acceleration0toMaxSpeedSec,
               double maxSpeedKmh) {
        // super: ruft den Konstruktor der Parent-Klasse auf (hier Vehicle)
        super(brand, model, acceleration0toMaxSpeedSec, maxSpeedKmh);
    }
}
