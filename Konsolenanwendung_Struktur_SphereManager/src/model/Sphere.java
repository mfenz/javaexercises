package model;

public class Sphere {
    private String name;
    private double radius;

    public Sphere(String name, double radius) {
        this.name = name;
        this.radius = radius;
    }

    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public String getName() {
        return name;
    }

    public double getRadius() {
        return radius;
    }
}
