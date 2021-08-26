package at.cb.empdeptspring.controller;

import at.cb.empdeptspring.model.Department;
import at.cb.empdeptspring.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public String getDepartments(){

        // Departments laden
        List<Department> departments = departmentService.getDepartments();
        departments.forEach(department -> {
            System.out.printf("ID: %d Name: %s %n", department.getId(), department.getName());
        });

        return "display_departments";
    }

}
