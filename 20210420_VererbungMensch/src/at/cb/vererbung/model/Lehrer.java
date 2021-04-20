package at.cb.vererbung.model;

import java.time.LocalDate;

public class Lehrer extends Mensch{
    private int dienstjahre;

    public Lehrer(String name, LocalDate geburtsdatum, int dienstjahre) {
        super(name, geburtsdatum);
        this.dienstjahre = dienstjahre;
    }

    // Methode überschreiben
    public void tagesBeschaeftigung(){
        System.out.printf("%s fährt in die Schule und unterrichtet.%n", getName());
    }
}
