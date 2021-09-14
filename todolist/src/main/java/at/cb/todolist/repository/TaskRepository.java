package at.cb.todolist.repository;

import at.cb.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    // Lädt alle Tasks mit der angegebenen User ID
    List<Task> findAllByUserId(int userId);

    // Lädt alle Tasks mit der angegebenen User ID die NICHT erledigt sind
    List<Task> findAllByUserIdAndDoneIsFalseOrderByDeadline(int userId);

    Optional<Task> findByIdAndUserId(int id, int userId);

}
