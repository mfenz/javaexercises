package at.cb.cms.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity(name = "role")
public class Role {
    @Id
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles") // wurde bereits in Variable "roles" definiert
    private List<User> users;
}
