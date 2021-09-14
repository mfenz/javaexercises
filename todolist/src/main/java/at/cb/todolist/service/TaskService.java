package at.cb.todolist.service;

import at.cb.todolist.formdata.TaskData;
import at.cb.todolist.model.Task;
import at.cb.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    /**
     * Lädt alle Tasks für die gegebene User ID
     * @param userId
     * @return
     */
    public List<Task> getTasksByUserId(int userId){
        return taskRepository.findAllByUserId(userId);
    }

    /**
     * Holt einen Task anhand der ID aus der Datenbank
     * @param id
     * @return
     */
    public Optional<Task> getTask(int id){
        return taskRepository.findById(id);
    }

    public void edit(TaskData taskData, int taskId, int userId){
        // Task laden
        Optional<Task> optionalTask = taskRepository.findByIdAndUserId(taskId, userId);
        // Task gefunden?
        if(optionalTask.isPresent()){
            // Task editieren
            Task task = optionalTask.get();
            task.setDeadline(taskData.getDeadline());
            task.setDone(taskData.isDone());
            task.setName(taskData.getName());
            task.setUser(taskData.getUser());

            // Task speichern
            task = taskRepository.save(task);
        }
    }

    public void delete(int taskId, int userId){
        Optional<Task> optionalTask = taskRepository.findByIdAndUserId(taskId,
                userId);
        if(optionalTask.isPresent()){
            Task task = optionalTask.get();
            taskRepository.delete(task);
        }
    }
}
