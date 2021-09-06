package at.cb.todolist.controller;

import at.cb.todolist.formdata.TaskData;
import at.cb.todolist.model.Task;
import at.cb.todolist.model.User;
import at.cb.todolist.service.TaskService;
import at.cb.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tasks") // für alle Links mit /tasks beginnend
public class TaskController {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @GetMapping("")
    public String displayTasksGet(){
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

}
