// https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html

public class Bicycle {
    protected int speed = 0;
    protected int gear = 1;

    public void setGear(int newValue) {
        gear = newValue;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }
}
