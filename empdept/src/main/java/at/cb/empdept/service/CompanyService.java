package at.cb.empdept.service;

import at.cb.empdept.dao.DepartmentDAO;
import at.cb.empdept.dao.EmployeeDAO;
import at.cb.empdept.model.Department;

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
}
