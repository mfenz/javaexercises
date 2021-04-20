package at.cb.vererbung.model;

import java.time.LocalDate;

public class Mensch {
    private String name;
    private LocalDate geburtsdatum;

    public Mensch(String name, LocalDate geburtsdatum) {
        this.name = name;
        this.geburtsdatum = geburtsdatum;
    }

    public void tagesBeschaeftigung(){
        System.out.printf("Ich bin ein Mensch, mein Name ist %s. Ich mache heute nichts. %n", name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }
}
