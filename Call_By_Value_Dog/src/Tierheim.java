import java.util.ArrayList;
import java.util.List;

public class Tierheim {
    public static void main(String[] args) {
        int anzahlLeckerli = 1000;
//        // verteilen!
        anzahlLeckerli = Tierheim.verteilen(anzahlLeckerli);

        List<Dog> dogs = new ArrayList<>();
        // spazieren ...
        Dog romeo = new Dog("Romeo");
        Dog julia = new Dog("Julia");
        dogs.add(romeo);
        dogs.add(julia);
        Tierheim.spazieren(dogs);

        System.out.println("Zählung der Hunde durch die Chefin!");
        for(int i = 0; i < dogs.size(); ++i){
            System.out.printf("Dieser Hund ist im Tierheim: %s\n", dogs.get(i).getName());
        }
        Tierheim.spazieren(romeo);
        System.out.printf("Ich bringe %s zurück!\n", romeo.getName());

        // verteilen
        Tierheim.verteilen(anzahlLeckerli);
    }

    static void spazieren(List<Dog> dogs){
        List<Dog> copy = new ArrayList<>();
        copy.addAll(dogs);
        // Ausgabe vom spazieren gehen ...
        // romeo nicht ausgeben!!!!!!
        for(int i = 0; i < copy.size(); ++i){
            // romeo finden und aus der Liste entfernen
            if(copy.get(i).getName().equals("Romeo")){
//                copy.get(i).setName("Depp");
//                copy.remove(i);
                break;
            }
        }
        for(int i = 0; i < copy.size(); ++i){
            System.out.printf("Ich gehe heute mit %s spazieren!\n", copy.get(i).getName());
        }
    }

    static void spazieren(Dog dog){
        System.out.printf("Ich gehe heute mit %s spazieren!\n", dog.getName());
        // Mir gefällt der Name Romeo nicht. Ich schreibe aufs Halsband ... Wuffi
        dog.setName("Wuffi");
    }

    static int verteilen(int anzahlLeckerli){
        // verteilen von 50 % aller Leckerlis
        System.out.printf("Ich habe insgesamt %d Leckerli. Ich verteile die Hälfte.\n", anzahlLeckerli);
        anzahlLeckerli = anzahlLeckerli / 2;
        System.out.printf("Ich habe nur mehr %d Leckerli.\n", anzahlLeckerli);
        return anzahlLeckerli;
    }

}
