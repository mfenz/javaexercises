package at.cb.kfzteile.model;

import java.util.List;
import java.util.Optional;

public class Benutzer {
    private int id;
    private String vorname;
    private String nachname;
    private String email;
    private String passwort;
    private Optional<Integer> warengruppeId;

    private List<Rolle> rollen;
    private Optional<Interessent> interessent;

    // Auf die Warengruppe muss extra zugegriffen werden!


    public Benutzer() {
    }

    public Benutzer(int id, String vorname, String nachname, String email, String passwort, Optional<Integer> warengruppeId, List<Rolle> rollen, Optional<Interessent> interessent) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.passwort = passwort;
        this.warengruppeId = warengruppeId;
        this.rollen = rollen;
        this.interessent = interessent;
    }

    public boolean isAdmin(){
//        for(int i = 0; i < rollen.size(); i++){
//            if(rollen.get(i).getId() == 1){
//                return true;
//            }
//        }

        for(Rolle rolle : rollen){
            if(rolle.getId() == 1){
                return true;
            }
        }
        return false;
    }

    public boolean isMitarbeiter(){
        for(Rolle rolle : rollen){
            if(rolle.getId() == 2){
                return true;
            }
        }
        return false;
    }

    public boolean isInteressent(){
        for(Rolle rolle : rollen){
            if(rolle.getId() == 3){
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public Optional<Integer> getWarengruppeId() {
        return warengruppeId;
    }

    public void setWarengruppeId(Optional<Integer> warengruppeId) {
        this.warengruppeId = warengruppeId;
    }

    public List<Rolle> getRollen() {
        return rollen;
    }

    public void setRollen(List<Rolle> rollen) {
        this.rollen = rollen;
    }

    public Optional<Interessent> getInteressent() {
        return interessent;
    }

    public void setInteressent(Optional<Interessent> interessent) {
        this.interessent = interessent;
    }
}
