import java.util.ArrayList;
import java.util.List;

public class Tierheim {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        // Zwei Hunde in Liste einfügen
        dogs.add(new Dog("Susi"));
        dogs.add(new Dog("Strolch"));
        // Morgen: Hunde-Anwesenheit prüfen
        for(int i = 0; i < dogs.size(); ++i){
            System.out.printf("%s ist da!\n", dogs.get(i).getName());
        }
        // Spazieren mit "dogs"
        spazieren(dogs);
        // Abend: Hunde-Anwesenheit prüfen
        for(int i = 0; i < dogs.size(); ++i){
            Dog dog = dogs.get(i);
            System.out.printf("%s ist da!\n", dog.getName());
        }
    }
    static void spazieren(List<Dog> list){
        // Strolch heute nicht mitnehmen
        for(int i = 0; i < list.size(); ++i){
            if(list.get(i).getName().equals("Strolch")){
                list.remove(i);
                break;
            }
        }
        // mit dem Rest spazieren
        for(int i = 0; i < list.size(); ++i){
            System.out.printf("Spazieren mit %s\n", list.get(i).getName());
        }
    }
}
