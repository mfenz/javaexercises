package at.cb.kfzteile.model;

/**
 * USER
 * ADMIN
 * INTERESSENT
 */
public class Rolle {
    private int id;
    private String name;

    public Rolle() {
    }

    public Rolle(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
