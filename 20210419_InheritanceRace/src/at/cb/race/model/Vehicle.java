package at.cb.race.model;

public class Vehicle {
    // protected Instanzvariable sichtbar in eigener Klasse + abgeleiteten Klassen
    protected String brand;
    protected String model;
    protected double acceleration0toMaxSpeedSec; // z. b. 5
    // maximale Geschwindigkeit in meter/s
    protected double maxSpeedMs;

    protected double currentSpeedMs; // z. B. 27 m/s
    protected double currentDistanceM; // z. b. 8323m

    public Vehicle(String brand, String model, double acceleration0toMaxSpeedSec, double maxSpeedKmh){
        this.brand = brand;
        this.model = model;
        this.acceleration0toMaxSpeedSec = acceleration0toMaxSpeedSec;
        // von km/h in m/s konvertieren
        this.maxSpeedMs = convertKmhToMs(maxSpeedKmh);
    }

    public void move(){
        // Annahme: lineare Beschleunigung
        // acceleration: wie viel wir pro Sekunde beschleunigen können
        double acceleration = maxSpeedMs / acceleration0toMaxSpeedSec;
        // beschleunigen, neue Geschwindigkeit berechnen
        currentSpeedMs += acceleration;
        // damit wir nicht schneller als maxSpeedMs werden
        if(currentSpeedMs > maxSpeedMs){
            currentSpeedMs = maxSpeedMs;
        }
        // Fahrzeug fortbewegen
        currentDistanceM += currentSpeedMs;
    }

    public static double convertKmhToMs(double kmh){
        return kmh / 3.6;
    }

    public static double convertMsToKmh(double ms){
        return ms * 3.6;
    }
}
