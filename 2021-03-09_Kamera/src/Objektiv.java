public class Objektiv {
    private String herstellerName;
    private int brennweiteMin;
    private int brennweiteMax;

    public Objektiv(String herstellerName, int brennweiteMin,
                    int brennweiteMax) {
        this.herstellerName = herstellerName;
        this.brennweiteMin = brennweiteMin;
        this.brennweiteMax = brennweiteMax;
    }

    public void printObjektivInfo(){

    }

    public String getHerstellerName() {
        return herstellerName;
    }

    public void setHerstellerName(String herstellerName) {
        this.herstellerName = herstellerName;
    }

    public int getBrennweiteMin() {
        return brennweiteMin;
    }

    public void setBrennweiteMin(int brennweiteMin) {
        this.brennweiteMin = brennweiteMin;
    }

    public int getBrennweiteMax() {
        return brennweiteMax;
    }

    public void setBrennweiteMax(int brennweiteMax) {
        this.brennweiteMax = brennweiteMax;
    }
}
