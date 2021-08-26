package at.cb.empdeptspring.model;

import lombok.Data;

import javax.persistence.*;

@Data // generiert automatisch getter und setter Methoden
@Entity(name = "department") // name = Tabellenname
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // damit Spring Data weiß, dass MySQL diese ID erzeugt
    @Column(name = "id") // welcher Spalte in der DB diese Instanzvariable entspricht
    private int id;

    @Column(name = "name")
    private String name;

    // IMMER einen leeren Konstruktor anlegen!
    public Department() {
    }
}
