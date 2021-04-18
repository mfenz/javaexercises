package at.cb.world.model;

import at.cb.world.ui.RacingUi;

public class Sailboat extends Boat{
    public Sailboat(String brand, String model,
                    double acceleration0toMaxSpeedSec,
                    double maxSpeed) {
        super(brand, model, acceleration0toMaxSpeedSec, maxSpeed);
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

    public void draw(){
        super.draw();
        String img;
        switch (boatStatus){
            case OK -> {
                img = RacingUi.sailboatImage;
            }
            case SUNK -> {
                img = RacingUi.sailboatUpsideDownImage;
            }
            default -> {
                img = RacingUi.sailboatImage;
            }
        }
        System.out.println(img.indent(getDistanceOffset()));
    }
}
