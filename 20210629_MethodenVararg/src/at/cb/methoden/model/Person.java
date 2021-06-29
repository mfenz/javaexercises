package at.cb.methoden.model;

import java.time.LocalDate;

public class Person {
    // Instanzvariablen (Eigenschaften einer Person)
    private String name;
    private LocalDate geburtsdatum;

    // Konstruktor (Instanzvariablen beim Erzeugen des Objekts mit Werten initialisieren)
    // public Klassenname() {  }
    // Innerhalb der runden Klammern: Übergabeparameter (Parameterliste)
    // Parameterliste: Mit Beistrich getrennte Variablendeklarationen
    public Person(String name, LocalDate geburtsdatum) {
        // Zuweisung des Übergabeparameters auf die Instanzvariable
        this.name = name;
        this.geburtsdatum = geburtsdatum;
        System.out.printf("Konstruktor Person: %s %s %n", this.name, this.geburtsdatum);
    }

    // Getter-Methoden
    // Geben den Wert von private Instanzvariablen zurück

    public String getName(){
        return name;
    }

    public LocalDate getGeburtsdatum(){
        return geburtsdatum;
    }
}
