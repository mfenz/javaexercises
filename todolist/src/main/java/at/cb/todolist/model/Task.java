package at.cb.todolist.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id") // über die Spalte "user_id" verknüpfen
    private User user;
    private LocalDateTime deadline;
    private boolean done;

    public Task() {
    }

    public Task(String name, User user, LocalDateTime deadline, boolean done) {
        this.name = name;
        this.user = user;
        this.deadline = deadline;
        this.done = done;
    }
}
