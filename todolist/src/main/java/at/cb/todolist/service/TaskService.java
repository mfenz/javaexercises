package at.cb.todolist.service;

import at.cb.todolist.formdata.TaskData;
import at.cb.todolist.model.Task;
import at.cb.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(TaskData data) {
        // Aus "data" ein Task-Objekt erzeugen
        Task task = new Task(data.getName(), data.getUser(),
                data.getDeadline(), data.isDone());

        // Task über Repository in DB speichern
        task = taskRepository.save(task);

        return task;
    }
}
