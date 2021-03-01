public class Gehaeuseschnecke extends Schnecke{
    private String gehaeuseFarbe;

    public Gehaeuseschnecke(String name, float speed, String gehaeuseFarbe) {
        super(name, speed);
        this.gehaeuseFarbe = gehaeuseFarbe;
    }

    public String getGehaeuseFarbe() {
        return gehaeuseFarbe;
    }

    @Override
    void kriechen() {
        zurueckgelegteDistanz = zurueckgelegteDistanz + getSpeed();
        System.out.printf("Gehäuseschnecke %s ist bei %f mm\n", getName(), getZurueckgelegteDistanz());
    }
}
