package at.cb.todolist.controller;

import at.cb.todolist.model.Task;
import at.cb.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/tasks")
public class AdminTaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("")
    public String displayTasks(
            Model model // für Attribute in der View
    ){
        // Liste aller Tasks
        List<Task> tasks = taskService.getTasks();
        model.addAttribute("tasks", tasks); // damit man in der View auf "tasks" zugreifen kann
        return "admin/admin_display_tasks";
    }

}
