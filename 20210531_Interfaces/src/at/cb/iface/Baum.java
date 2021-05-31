package at.cb.iface;

public class Baum implements Moveable{
    private int hoehe;

    public Baum(int hoehe){
        this.hoehe = hoehe;
    }

    @Override
    public void move() {
        hoehe += 1;
        System.out.printf("Der Baum mit einer Höhe von %d Meter wächst und " +
                "schwingt von links nach rechts%n", hoehe);
    }
}
