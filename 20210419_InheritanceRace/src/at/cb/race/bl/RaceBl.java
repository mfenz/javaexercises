package at.cb.race.bl;

import at.cb.race.model.*;

import java.util.ArrayList;
import java.util.List;

public class RaceBl {

    // Hier kommen alle Teilnehmer rein
    // Datentyp in spitzen Klammern (Generics)
    private List<Vehicle> participants = new ArrayList<>();

    public void addVehicles() {
        Car mercedes = new Car("Mercedes", "S500", 20, 270);
        Train oebb = new Train("ÖBB", "Nachtzug", 40, 160);
        MotorYacht princess = new MotorYacht("Princess", "V65",
                30, 70, 1.2);
        Sailboat beneteau = new Sailboat("Beneteau", "Oceanis Yacht 62", 40,
                14.8, 2.2);
        participants.add(mercedes);
        participants.add(oebb);
        participants.add(princess);
        participants.add(beneteau);
    }

    public void startRace() {
        while (true) {
            // für jedes Vehicle als participant
            for (Vehicle vehicle : participants) {
                // Bewegen
                vehicle.move();
            }

            for (Vehicle vehicle : participants) {
                // Fahrzeuge ausgeben
                vehicle.draw();
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
