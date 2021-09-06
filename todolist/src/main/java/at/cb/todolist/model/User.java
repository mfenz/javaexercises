package at.cb.todolist.model;

import lombok.Data;

import javax.persistence.*;

@Data // Getter und Setter automatisch generieren
// name= DB-Tablename
@Entity(name = "users") // ORM für diese Klasse aktivieren
public class User {
    // Welche Variable ist der Primary Key?
    @Id
    // MySQL-DB generiert diesen Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Welche Instanzvariable entspricht welcher Spalte?
    @Column(name = "id")
    private int id;

    private String email;
    private String password;
    private String name;

    public User() {
    }

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
