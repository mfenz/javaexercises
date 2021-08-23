package at.cb.empdept.service;

import at.cb.empdept.dao.DepartmentDAO;
import at.cb.empdept.dao.EmployeeDAO;
import at.cb.empdept.dao.EmployeeInProjectDAO;
import at.cb.empdept.dao.ProjectDAO;
import at.cb.empdept.model.Department;
import at.cb.empdept.model.Employee;
import at.cb.empdept.model.EmployeeInProject;
import at.cb.empdept.model.Project;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
        // if EXTERN --> KEINE Mitarbeiter zurückgeben

        // if ADMIN --> alle Mitarbeiter

        // if NOT admin --> nur eigene Abteilung
        return EmployeeDAO.getEmployees();
    }

    public static Optional<Employee> getEmployeeById(int employeeId){
        return EmployeeDAO.getEmployeeById(employeeId);
    }

    public static List<Project> getProjects(){
        return ProjectDAO.getProjects();
    }

    public static void createEmployeeInProject(int employeeId, int projectId, Instant start, Instant end){
        EmployeeInProjectDAO.createEmployeeInProjectDAO(employeeId, projectId, start, end);
    }

    public static List<EmployeeInProject> getProjectTimeByEmployeeId(int employeeId){
        // Liste mit ALLEN EmployeeInProject Einträgen
        List<EmployeeInProject> employeesInProjects = EmployeeInProjectDAO.getEmployeesInProjects();

        // Filtern: Nur Einträge beibehalten die employeeId entsprechen

        // Hier sind nur EIPs drinnen wo employee.id = employeeId zutrifft
//        List<EmployeeInProject> result = new ArrayList<>();
//        for(EmployeeInProject eip : employeesInProjects){
//            if(eip.getEmployee().getId() == employeeId){
//                result.add(eip);
//            }
//        }

        // Filter mit Streams
//        List<EmployeeInProject> result = employeesInProjects.stream().filter(eip -> {
//            if(eip.getEmployee().getId() == employeeId){
//                return true;
//            }
//            return false;
//        }).collect(Collectors.toList());

        List<EmployeeInProject> result = employeesInProjects.stream()
                .filter(eip -> eip.getEmployee().getId() == employeeId)
                .collect(Collectors.toList());

        return result;
    }

    // Alle Mitarbeiter, gruppiert nach Abteilung
    public static Map<Department, List<Employee>> getEmployeesByDepartment(){
        List<Employee> employees = getEmployees();

        Map<Department, List<Employee>> collect = employees.stream()
                //.filter(employee -> employee.getSalary() > 5000f)
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return collect;
    }

    // Die Summe der Gehälter aller Mitarbeiter, gruppiert nach Abteilung
    public static Map<Department, Double> getSalariesByDepartment(){
        List<Employee> employees = getEmployees();
        Map<Department, Double> collect = employees.stream()
                .collect(Collectors
                        .groupingBy(
                                Employee::getDepartment,
                                Collectors.summingDouble(value -> value.getSalary()
                                )
                        )
                );
        return collect;
    }
}
