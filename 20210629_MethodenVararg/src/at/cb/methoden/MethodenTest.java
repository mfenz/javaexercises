package at.cb.methoden;

import at.cb.methoden.model.Person;

import java.time.LocalDate;

public class MethodenTest {
    public static void main(String[] args) {
        MethodenTest test = new MethodenTest();
        test.personenAnlegen();
    }

    public void personenAnlegen(){
        // Objekte der Klasse Person erzeugen
        // Klasse nameVariable = new Klasse(parameter des Konstruktors);
        Person hansi = new Person("Hansi", LocalDate.of(2000, 3, 1));
        Person susi = new Person("Susi", LocalDate.of(1990, 12, 1));

        print(hansi, susi);
        print();
        print(hansi);
        print(susi);
    }

    // Datentyp... variablenname   <-- Vararg
    // Pro Parameterliste nur max 1 Vararg-Definition geben
    // Vararg-Definition muss immer am Ende der Parameterliste stehen
    public void print(Person... personen){
        for(int i = 0; i < personen.length; i++){
            Person p = personen[i];
            print(p);
        }
    }

    public void print(Person person){
        System.out.printf("Person %s geboren am %s %n" ,person.getName(), person.getGeburtsdatum());
    }

    public void printf(String format, Object... daten){

    }

    public void ausgabe(LocalDate datum, Person... personen){

    }
}
