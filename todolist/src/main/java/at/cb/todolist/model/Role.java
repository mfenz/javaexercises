package at.cb.todolist.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity(name = "role")
@ToString(exclude = {"users"})
public class Role {
    @Id
    private String name;

    @ManyToMany(mappedBy = "roles") // Info wurde bereits in Klasse "User" in Instanzvariable "roles" definiert
    private List<User> users;

    public Role() {
    }
}
