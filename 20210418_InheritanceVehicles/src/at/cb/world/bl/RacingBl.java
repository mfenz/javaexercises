package at.cb.world.bl;

import at.cb.world.model.*;
import at.cb.world.ui.RacingUi;

import java.util.ArrayList;
import java.util.List;

public class RacingBl {
    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicles(){
        Car mercedes = new Car("Mercedes", "S500", 20, 270);
        Sailboat beneteau = new Sailboat("Beneteau", "Oceanis Yacht 62", 40, 14.8);
        MotorYacht princess = new MotorYacht("Princess", "V65", 30, 70);
        Train oesterreichischeBummelBahn = new Train("ÖBB", "CityJet", 50, 160);
        vehicles.add(mercedes);
        vehicles.add(beneteau);
        vehicles.add(princess);
        vehicles.add(oesterreichischeBummelBahn);
    }

    public void race(){
        while (true){
            for(Vehicle vehicle : vehicles){
                vehicle.move();
                vehicle.draw();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
