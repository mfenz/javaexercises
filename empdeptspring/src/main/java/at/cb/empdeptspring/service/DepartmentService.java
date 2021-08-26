package at.cb.empdeptspring.service;

import at.cb.empdeptspring.model.Department;
import at.cb.empdeptspring.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired // initialisiert die Variable mit einem Objekt der Klasse (automatisch)
    private DepartmentRepository departmentRepository;

    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }
}
