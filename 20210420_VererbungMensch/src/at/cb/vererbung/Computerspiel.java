package at.cb.vererbung;

import at.cb.vererbung.model.Lehrer;
import at.cb.vererbung.model.Mensch;
import at.cb.vererbung.model.Schueler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Computerspiel {
    private List<Mensch> personen = new ArrayList<>();

    public static void main(String[] args) {
        Computerspiel computerspiel = new Computerspiel();
        computerspiel.addPersonen();
        computerspiel.play();
    }

    private void addPersonen(){
        Mensch m1 = new Schueler("Hansi", LocalDate.of(2005, 5, 5), 10);
        personen.add(m1);
        Mensch m2 = new Lehrer("Prof. Albert", LocalDate.of(1900, 1, 5), 90);
        personen.add(m2);
        Mensch m3 = new Mensch("Thomas", LocalDate.of(1990, 6, 3));
        personen.add(m3);
    }

    private void play(){
        for(Mensch mensch : personen){
            mensch.tagesBeschaeftigung();
        }
    }
}
