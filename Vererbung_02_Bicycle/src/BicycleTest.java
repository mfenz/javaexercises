public class BicycleTest {
    public static void main(String[] args) {
        BicycleTest t = new BicycleTest();
        t.testBikes();
    }
    public void testBikes(){
        // 2 MountainBikes und 2 RoadBikes
        MountainBike m1 = new MountainBike();
        MountainBike m2 = new MountainBike();
        RoadBike r1 = new RoadBike();
        RoadBike r2 = new RoadBike();
        // MountainBikes und RoadBikes
        // können auch einem Bicycle zugewiesen
        // werden weil MountainBike is a Bicycle
        // und RoadBike is a Bicycle
        Bicycle b1 = new MountainBike();
        Bicycle b2 = new RoadBike();
        // Methoden der Objekte aufrufen...
        m1.setGear(1);
        m1.speedUp(5);
        // Nur MountainBikes haben setHeight()
        m1.setHeight(100);
        r1.setGear(1);
    }
}
