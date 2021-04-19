package at.cb.race.bl;

import at.cb.race.model.Car;
import at.cb.race.model.Train;
import at.cb.race.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class RaceBl {

    // Hier kommen alle Teilnehmer rein
    // Datentyp in spitzen Klammern (Generics)
    private List<Vehicle> participants = new ArrayList<>();

    public void addVehicles(){
        Car mercedes = new Car("Mercedes", "S500", 20, 270);
        Train oebb = new Train("ÖBB", "Nachtzug", 40, 160);
        participants.add(mercedes);
        participants.add(oebb);
    }

    public void startRace(){
        while (true){
            // für jedes Vehicle als participant
            for(Vehicle vehicle : participants){
                // Bewegen
                vehicle.move();
            }

            try {
                // 1000: 1 Sekunde warten
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
