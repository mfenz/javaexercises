package at.cb.race.model;

import at.cb.race.ui.RaceUi;

public class Car extends Vehicle{
    // Konstruktor
    public Car(String brand, String model, double acceleration0toMaxSpeedSec,
               double maxSpeedKmh) {
        // super: ruft den Konstruktor der Parent-Klasse auf (hier Vehicle)
        super(brand, model, acceleration0toMaxSpeedSec, maxSpeedKmh);
    }

    // Draw-Methode der Vehicle-Klasse überschreiben
    public void draw(){
        // Ruft die draw() Methode der Vehicle-Klasse auf
        // Allgemeine Information für Vehicle ausgeben
        super.draw();
        System.out.println(RaceUi.carImage.indent(getDistanceOffset()));
    }
}
