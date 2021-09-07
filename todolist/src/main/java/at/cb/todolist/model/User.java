package at.cb.todolist.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role", // wie heißt unser "Join Table"?
            joinColumns = @JoinColumn(name = "user_id"), // mit welcher Spalte im Join Table soll die User-ID verknüpft werden?
            inverseJoinColumns = @JoinColumn(name = "role_name") // wie heißt die Spalte mit der "Role" verknüpft wird?
    )
    private List<Role> roles;

    public User() {
    }

    public User(String email, String password, String name, List<Role> roles) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.roles = roles;
    }
}
