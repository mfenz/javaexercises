package at.cb.empdept.servlet;

import at.cb.empdept.model.Department;
import at.cb.empdept.model.Employee;
import at.cb.empdept.service.CompanyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "EditEmployeeServlet", value = "/editemployee")
public class EditEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> departments = CompanyService.getDepartments();
        req.setAttribute("departments", departments);

        // Aktuelle Werte (Employee) laden
        int employeeId = Integer.parseInt(req.getParameter("id"));
        Optional<Employee> employeeOptional = CompanyService.getEmployeeById(employeeId);
        // Wurde ein Employee mit dieser ID gefunden?
        if(employeeOptional.isPresent()){
            req.setAttribute("employee", employeeOptional.get());
        }
        getServletContext().getRequestDispatcher("/edit_employee.jsp").forward(req, resp);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();

        // Welcher Mitarbeiter wird bearbeitet?
        int employeeId = Integer.parseInt(req.getParameter("id"));

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        float salary = 0;
        if(req.getParameter("salary") != null && !req.getParameter("salary").isBlank()){
            try {
                salary = Float.parseFloat(req.getParameter("salary"));
            } catch (NumberFormatException e){
                errors.add("Salary is not a number");
            }
        } else {
            errors.add("Salary cannot be empty");
        }
        int departmentId = Integer.parseInt(req.getParameter("department_id"));



        // Prüfen ob Eingaben korrekt sind
        if(firstname == null || firstname.isBlank()){
            errors.add("Firstname cannot be empty");
        }
        if(lastname == null || lastname.isBlank()){
            errors.add("Lastname cannot be empty");
        }
        if(salary < 0){
            errors.add("Salary cannot be negative");
        }


        // Department anhand der ID laden
        Optional<Department> optionalDepartment = CompanyService.getDepartmentById(departmentId);
        if(optionalDepartment.isEmpty()){
            errors.add("Department not found");
        }

        // Employee-Objekt laden
        Optional<Employee> optionalEmployee = CompanyService.getEmployeeById(employeeId);
        if(optionalEmployee.isEmpty()){
            errors.add("Employee not found");
        }

        // Änderungen nur durchführen wenn es keine Fehler gibt!
        if(errors.isEmpty()){
            Employee emp = optionalEmployee.get();

            // Werte im Employee-Objekt verändern
            emp.setFirstname(firstname);
            emp.setLastname(lastname);
            emp.setSalary(salary);
            emp.setDepartment(optionalDepartment.get());

            // Employee an Service übergeben (um Änderungen in der DB vorzunehmen)
            CompanyService.editEmployee(emp);

            resp.sendRedirect("./employees");
            return;
        } else {

            // Fehlermeldungen als Attribute setzen
            req.setAttribute("errors", errors);

            // Darstellung der Seite (Formular)
            doGet(req, resp);
        }
    }
}
