package at.cb.immo.model;

public class Immobilie {
    private int id;
    private String type;
    private String adresse;
    private float kaufpreis;
    private String fotoUrl;

    public Immobilie() {
    }

    public Immobilie(int id, String type, String adresse, float kaufpreis, String fotoUrl) {
        this.id = id;
        this.type = type;
        this.adresse = adresse;
        this.kaufpreis = kaufpreis;
        this.fotoUrl = fotoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public float getKaufpreis() {
        return kaufpreis;
    }

    public void setKaufpreis(float kaufpreis) {
        this.kaufpreis = kaufpreis;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }
}
