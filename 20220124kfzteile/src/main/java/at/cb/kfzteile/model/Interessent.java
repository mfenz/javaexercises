package at.cb.kfzteile.model;

public class Interessent {
    private String strasse;
    private String plz;
    private String ort;
    private String firmenname;

    public Interessent() {
    }

    public Interessent(String strasse, String plz, String ort, String firmenname) {
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
        this.firmenname = firmenname;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getFirmenname() {
        return firmenname;
    }

    public void setFirmenname(String firmenname) {
        this.firmenname = firmenname;
    }
}
