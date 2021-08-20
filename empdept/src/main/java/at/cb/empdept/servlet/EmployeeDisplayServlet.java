package at.cb.empdept.servlet;

import at.cb.empdept.model.Employee;
import at.cb.empdept.model.EmployeeInProject;
import at.cb.empdept.service.CompanyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "EmployeeDisplayServlet", value = "/employee")
public class EmployeeDisplayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // wer soll dargestellt werden?
        int employeeId = Integer.parseInt(request.getParameter("id"));

        // Employee anhand der ID aus der Datenbank holen
        Optional<Employee> optionalEmployee = CompanyService.getEmployeeById(employeeId);

        // Wurde ein Employee gefunden (hat Optional ein Employee-Objekt enthalten?)
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            List<EmployeeInProject> employeeInProjectList =
                    CompanyService.getProjectTimeByEmployeeId(employeeId);

            // Employee zur Darstellung als Request Attribute setzen
            request.setAttribute("employee", employee);

            // Employee in project list als Request Attribute setzen
            request.setAttribute("employeeInProjectList", employeeInProjectList);
        } else {
            // Fehlermeldung hinterlegen
            request.setAttribute("error", "Mitarbeiter nicht gefunden");
        }

        getServletContext().getRequestDispatcher("/display_employee.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }
}
