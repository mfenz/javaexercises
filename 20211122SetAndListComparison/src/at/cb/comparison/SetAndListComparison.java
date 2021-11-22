package at.cb.comparison;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetAndListComparison {
    public static void main(String[] args) {
        SetAndListComparison salc = new SetAndListComparison();
        salc.workWithLists();
        salc.workWithSets();
    }

    public void workWithLists(){
        System.out.println("--- Listen --- ");
        // Wörter zur Liste hinzufügen: Bernd, Daniel, Marc, Bernd, Daniel
        // Anschließend die Liste auf der Konsole ausgeben
        List<String> names = new ArrayList<>();
        names.add("Bernd");
        names.add("Daniel");
        names.add("Marc");
        names.add("Bernd");
        names.add("Daniel");
        for(String name : names){
            System.out.println(name);
        }

        System.out.println("--- Listen-Einträge in ein Set einfügen --- ");
        // Die Liste wird beim Erzeugen des Sets übergeben
        Set<String> namesSet = new HashSet<>(names);
        for(String name : namesSet){
            System.out.println(name);
        }
    }

    public void workWithSets(){
        System.out.println("--- Sets --- ");
        // Wörter zur Set hinzufügen: Bernd, Daniel, Marc, Bernd, Daniel
        // Anschließend das Set auf der Konsole ausgeben
        Set<String> names = new HashSet<>();
        names.add("Bernd");
        names.add("Daniel");
        names.add("Marc");
        names.add("Bernd");
        names.add("Daniel");
        for(String name : names){
            System.out.println(name);
        }



        Set<Person> personen = new HashSet<>();
        Person hansi = new Person("Hansi", "Müller");
        Person susi = new Person("Susi", "Müller");
        personen.add(hansi);
        personen.add(susi);
        // Wie heißen die Personen hier?

        System.out.println("--- vor der Veränderung --- ");
        for (Person person : personen){
            System.out.printf("%s %s %n", person.getVorname(), person.getNachname());
        }

        hansi.setVorname("Susi");

        // Wie heißen die Personen hier?

        System.out.println("--- nach der Veränderung --- ");
        for (Person person : personen){
            System.out.printf("%s %s %n", person.getVorname(), person.getNachname());
        }
    }
}
