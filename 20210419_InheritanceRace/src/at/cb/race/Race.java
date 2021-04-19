package at.cb.race;

import at.cb.race.bl.RaceBl;

public class Race {
    public static void main(String[] args) {
        RaceBl bl = new RaceBl();
        bl.addVehicles();
        bl.startRace();
    }
}
