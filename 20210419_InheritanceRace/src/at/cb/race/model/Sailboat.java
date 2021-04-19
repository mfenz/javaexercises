package at.cb.race.model;

import at.cb.race.ui.RaceUi;

public class Sailboat extends Boat{
    public Sailboat(String brand, String model,
                    double acceleration0toMaxSpeedSec,
                    double maxSpeedKmh, double draft) {
        super(brand, model, acceleration0toMaxSpeedSec, maxSpeedKmh, draft);
    }

    public void draw(){
        super.draw();
        if(boatStatus == BoatStatus.SUNK){
            System.out.println(RaceUi.sailboatUpsideDownImage.indent(getDistanceOffset()));
        } else {
            System.out.println(RaceUi.sailboatImage.indent(getDistanceOffset()));
        }

    }

    public void move(){
        if(boatStatus == BoatStatus.SUNK){

        } else if(currentSpeedMs >= maxSpeedMs){
            boatStatus = BoatStatus.SUNK;
            currentSpeedMs = 0;
        } else {
            super.move();
        }
    }
}
