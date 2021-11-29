package at.cb.inskriptionen.model;

public class UniEnrolment {
    private String uniName;
    private int enroledMen;
    private int enroledWoman;
    private int year;

    public UniEnrolment(String uniName, int enroledMen, int enroledWoman,
                        int year) {
        this.uniName = uniName;
        this.enroledMen = enroledMen;
        this.enroledWoman = enroledWoman;
        this.year = year;
    }

    public int getEnroledTotal(){
        return enroledMen + enroledWoman;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public int getEnroledMen() {
        return enroledMen;
    }

    public void setEnroledMen(int enroledMen) {
        this.enroledMen = enroledMen;
    }

    public int getEnroledWoman() {
        return enroledWoman;
    }

    public void setEnroledWoman(int enroledWoman) {
        this.enroledWoman = enroledWoman;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
