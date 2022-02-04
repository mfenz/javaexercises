package at.cb.kfzteile.model;

import java.util.List;

public class Warengruppe {
    private int id;
    private Benutzer leiter;
    private String bezeichnung;

    private List<Dokument> dokumente;

    public Warengruppe() {
    }

    public Warengruppe(int id, Benutzer leiter, String bezeichnung, List<Dokument> dokumente) {
        this.id = id;
        this.leiter = leiter;
        this.bezeichnung = bezeichnung;
        this.dokumente = dokumente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Benutzer getLeiter() {
        return leiter;
    }

    public void setLeiter(Benutzer leiter) {
        this.leiter = leiter;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public List<Dokument> getDokumente() {
        return dokumente;
    }

    public void setDokumente(List<Dokument> dokumente) {
        this.dokumente = dokumente;
    }
}
