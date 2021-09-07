package at.cb.todolist.controller;

import at.cb.todolist.formdata.TaskData;
import at.cb.todolist.model.Task;
import at.cb.todolist.model.User;
import at.cb.todolist.service.TaskService;
import at.cb.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/tasks") // für alle Links mit /tasks beginnend
public class TaskController {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    /**
     * Darstellung aller Tasks des Users
     * @return
     */
    @GetMapping("")
    public String displayTasksGet(
            Principal principal, // enthält Informationen über den angemeldeten User
            Model model
    ){
        // Wer ist gerade angemeldet? Über Principal User-ID auslesen
        // Principal Name wurde im UserDetailsService hinterlegt
        int userId = Integer.parseInt(principal.getName());

        List<Task> tasks = taskService.getTasksByUserId(userId);
        // List<Task> zum Model hinzufügen (um in der View einen Zugriff auf die Liste zu haben)
        model.addAttribute("tasks", tasks);

        // https://stackoverflow.com/a/6162091
//        UserDetails userDetails =
//                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(userDetails);

        return "display_tasks";
    }

    @GetMapping("/create")
    public String createTaskGet(
            TaskData taskData,
            Model model // zum Hinterlegen d. Attribute für Thymeleaf
    ){
        //Eine Liste von User zur Darstellung in HTML <select>
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "create_task";
    }

    @PostMapping("/create")
    public String createTaskPost(
            @Valid TaskData taskData,
            BindingResult bindingResult,
            Model model
    ) {
        // Gab es Fehler bei der Validierung?
        if(bindingResult.hasErrors()){
            return createTaskGet(taskData, model);
        }

        // Speichern
        Task task = taskService.createTask(taskData);
        return "redirect:/tasks";
    }

    /**
     * /tasks   <-- Zeigt alle Tasks an
     * /tasks/create <-- Erstellt einen neuen Task an
     */



    @GetMapping("/{taskId}/")
    public String editTaskGet(
            @PathVariable int taskId, // den Wert von {taskId}
            Model model,
            TaskData taskData
    ){
        // Task mit der ID laden
        Task task = taskService.getTask(taskId).get();

        // Task-Daten in "TaskData" speichern
        taskData.setName(task.getName());
        taskData.setDeadline(task.getDeadline());
        taskData.setUser(task.getUser());
        taskData.setDone(task.isDone());

        // Liste aller User für die Select-Box in Model speichern
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);

        // Task im Model speichern
        model.addAttribute("task", task);

        return "edit_task";
    }

    @PostMapping("/{taskId}/")
    public String editTaskPost(
            @Valid TaskData taskData,
            BindingResult bindingResult,
            @PathVariable int taskId,
            Model model,
            Principal principal
    ) {
        // Gab es Fehler bei der Validierung?
        if(bindingResult.hasErrors()){
            // Weiterleiten zum Formular
            return editTaskGet(taskId, model, taskData);
        }
        int userId = Integer.parseInt(principal.getName());

        // TaskData an Service übergeben, Service ändert Daten in der Datenbank
        taskService.edit(taskData, taskId, userId);

        // Auf die Task-Übersicht weiterleiten
        return "redirect:/tasks";
    }

    @PostMapping("/{taskId}/delete")
    public String deleteTaskPost(
            @PathVariable int taskId,
            Principal principal
    ){
        int userId = Integer.parseInt(principal.getName());

        // Task - Service zum Löschen aufrufen
        taskService.delete(taskId, userId);

        // Weiterleitung zur Übersichts-Seite
        return "redirect:/tasks";
    }

}
