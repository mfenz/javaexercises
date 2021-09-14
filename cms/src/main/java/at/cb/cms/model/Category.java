package at.cb.cms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

// Generieren von Getter- und SEtter-Methoden
@Data
// Welche DB Tabelle?
@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", unique = true)
    private String name;
    @ManyToMany(mappedBy = "categories")
    private List<Article> articles;

    public Category() {
    }
}
