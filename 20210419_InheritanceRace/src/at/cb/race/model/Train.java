package at.cb.race.model;

import at.cb.race.ui.RaceUi;

public class Train extends Vehicle{
    public Train(String brand, String model, double acceleration0toMaxSpeedSec,
                 double maxSpeedKmh) {
        super(brand, model, acceleration0toMaxSpeedSec, maxSpeedKmh);
    }

    // Draw-Methode der Vehicle-Klasse überschreiben
    public void draw(){
        // Ruft die draw() Methode der Vehicle-Klasse auf
        // Allgemeine Information für Vehicle ausgeben
        super.draw();
        System.out.println(RaceUi.trainImage.indent(getDistanceOffset()));
    }
}
