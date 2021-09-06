package at.cb.todolist.formdata;

import at.cb.todolist.model.User;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class TaskData {
    @Length(min = 1, max = 1000)
    private String name;
    @NotNull
    private User user;
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm", fallbackPatterns = {"yyyy/dd/MM"})
    private LocalDateTime deadline;
    private boolean done;
}
