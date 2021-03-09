public class Kamera {
    private String herstellerName;
    private String modellName;
    private Objektiv objektiv;

    public Kamera(String herstellerName, String modellName, Objektiv objektiv) {
        this.herstellerName = herstellerName;
        this.modellName = modellName;
        this.objektiv = objektiv;
    }

    public void printKameraInfo() {
        System.out
                .printf("Fotografieren mit der Kamera %s %s und dem Objektiv %s\n",
                        herstellerName, modellName, objektiv.getHerstellerName());
    }

    public void fotografieren() {

    }

    public String getHerstellerName() {
        return herstellerName;
    }

    public void setHerstellerName(String herstellerName) {
        this.herstellerName = herstellerName;
    }

    public String getModellName() {
        return modellName;
    }

    public void setModellName(String modellName) {
        this.modellName = modellName;
    }

    public Objektiv getObjektiv() {
        return objektiv;
    }

    public void setObjektiv(Objektiv objektiv) {
        this.objektiv = objektiv;
    }
}
