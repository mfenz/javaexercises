package at.cb.tt;

public class Racetrack {
    public static void main(String[] args) {
        Thread porsche = new Thread(new Car("Porsche"));
        Thread ferrari = new Thread(new Car("Ferrari"));
        Thread mclaren = new Thread(new Car("McLaren"));
        porsche.start();
        ferrari.start();
        mclaren.start();
    }
}
