public class SchulverwaltungTest {
    public static void main(String[] args) {
        Mensch person1 = new Kind("Susi", 3);
        Mensch person2 = new Lehrer("Frau Professor", 33);

        person1.printInfo();
        person2.printInfo();
    }
}
