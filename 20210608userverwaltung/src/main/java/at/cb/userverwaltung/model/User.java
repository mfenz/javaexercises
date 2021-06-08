package at.cb.userverwaltung.model;

public class User {
    private int id;
    private String name;

    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    // Getter-Methoden
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    // Setter-Methoden
    public void setName(String name){
        this.name = name;
    }
}
