package at.cb.empdept.service;

import at.cb.empdept.dao.DepartmentDAO;
import at.cb.empdept.dao.EmployeeDAO;
import at.cb.empdept.dao.EmployeeInProjectDAO;
import at.cb.empdept.dao.ProjectDAO;
import at.cb.empdept.model.Department;
import at.cb.empdept.model.Employee;
import at.cb.empdept.model.Project;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public class CompanyService {
    public static int createDepartment(String name) {
        return DepartmentDAO.createDepartment(name);
    }

    public static List<Department> getDepartments() {
        return DepartmentDAO.getDepartments();
    }

    public static int createEmployee(String firstname, String lastname,
                                     float salary,
                                     int departmentId) throws ServiceInputException {
        // Department anhand der ID aus der DB laden
        Optional<Department> optionalDepartment =
                DepartmentDAO.getDepartmentById(
                departmentId);
        // .isPresent() überprüft ob ein Eintrag (Objekt) hinterlegt ist
        if (optionalDepartment.isPresent()) {
            // .get() holt das Objekt aus dem Optional
            Department department = optionalDepartment.get();
            return EmployeeDAO.createEmployee(firstname, lastname, salary,
                    department);
        }
        throw new ServiceInputException("Department nicht gefunden");
    }

    public static List<Employee> getEmployees(){
        return EmployeeDAO.getEmployees();
    }

    public static List<Project> getProjects(){
        return ProjectDAO.getProjects();
    }

    public static void createEmployeeInProject(int employeeId, int projectId, Instant start, Instant end){
        EmployeeInProjectDAO.createEmployeeInProjectDAO(employeeId, projectId, start, end);
    }
}
