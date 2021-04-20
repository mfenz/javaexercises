package at.cb.vererbung.model;

import java.time.LocalDate;

public class Schueler extends Mensch{
    private int schulstufe;

    public Schueler(String name, LocalDate geburtsdatum, int schulstufe) {
        super(name, geburtsdatum);
        this.schulstufe = schulstufe;
    }

    public void tagesBeschaeftigung(){
        zuFussInDieSchuleGehen();
        lernen();
    }

    public void zuFussInDieSchuleGehen(){
        System.out.printf("%s geht zu fuß in die Schule.%n", getName());
    }

    public void lernen(){
        System.out.printf("%s lernt.%n", getName());
    }
}
