public class Nacktschnecke extends Schnecke{
    public Nacktschnecke(String name, float speed) {
        super(name, speed);
    }

    @Override
    void kriechen() {
        zurueckgelegteDistanz = zurueckgelegteDistanz + getSpeed();
        System.out.printf("Nacktschnecke %s ist bei %f mm\n", getName(), getZurueckgelegteDistanz());
    }
}
