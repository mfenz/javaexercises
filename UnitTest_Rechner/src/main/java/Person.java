public class Person {
    // Attribute
    // Person-Position
    double lat, lon;
    //0 kein Hunger
    int hunger;
    // Methode
    void move(){
        lat++;
        lon++;
        // Bewegung
        // macht hungrig
        hunger++;
    }
    void essen(){
        hunger--;
    }


    // Attribute
    String name;
    String geburtsort;
    int geburtsjahr;
    // Konstruktor
    public Person() {
    }
    // Methode
    public String getName() {
        return name;
    }
    // Methode
    public void setName(String name) {
        this.name = name;
    }
}
