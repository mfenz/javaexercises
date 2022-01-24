package at.cb.kfzteile.model;

public class Dokument {
    private int id;
    private int warengruppeId;
    private String pfad;
    private String dateiname;

    public Dokument() {
    }

    public Dokument(int id, int warengruppeId, String pfad, String dateiname) {
        this.id = id;
        this.warengruppeId = warengruppeId;
        this.pfad = pfad;
        this.dateiname = dateiname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWarengruppeId() {
        return warengruppeId;
    }

    public void setWarengruppeId(int warengruppeId) {
        this.warengruppeId = warengruppeId;
    }

    public String getPfad() {
        return pfad;
    }

    public void setPfad(String pfad) {
        this.pfad = pfad;
    }

    public String getDateiname() {
        return dateiname;
    }

    public void setDateiname(String dateiname) {
        this.dateiname = dateiname;
    }
}
