public class Kamera {
    // Instanzvariablen
    private String herstellerName;
    private String modellName;
    private Objektiv objektiv;
    private int counter;

    public Kamera(String herstellerName, String modellName, Objektiv objektiv) {
        this.herstellerName = herstellerName;
        this.modellName = modellName;
        this.objektiv = objektiv;
    }

    public void printKameraInfo() {
        System.out
                .printf("Fotografieren mit der Kamera %s %s und dem Objektiv " +
                                "%s\n",
                        herstellerName, modellName,
                        objektiv.getHerstellerName());
    }

    public void fotografieren() {
        System.out
                .printf("Fotografieren mit der Kamera %s %s und dem Objektiv " +
                                "%s\n",
                        herstellerName, modellName,
                        objektiv.getHerstellerName());
        counter += 1;
        System.out.printf("IMG_%d.jpg \n", counter);
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
