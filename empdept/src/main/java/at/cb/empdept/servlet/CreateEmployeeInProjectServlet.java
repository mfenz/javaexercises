package at.cb.empdept.servlet;

import at.cb.empdept.model.Employee;
import at.cb.empdept.model.Project;
import at.cb.empdept.service.CompanyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "CreateEmployeeInProjectServlet", value =
        "/addtime")
public class CreateEmployeeInProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // Alle Employees und alle Projects laden (für die Auswahl in HTML Selectbox)
        List<Employee> employees = CompanyService.getEmployees();
        List<Project> projects = CompanyService.getProjects();

        // Request Attributes für die Darstellung der Listen-Inhalte im JSP
        request.setAttribute("employees", employees);
        request.setAttribute("projects", projects);

        // Weiterleiten an JSP
        getServletContext().getRequestDispatcher("/create_employee_in_project.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // Formulardaten einlesen
        int employeeId = Integer.parseInt(request.getParameter("employee_id"));
        int projectId = Integer.parseInt(request.getParameter("project_id"));

        // 13.08.2021 10:00 --> Instant
        // 5.8.2021
        // 5/8/2021
        // 05.08.2021
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy H:m");

        // Start-Datum
        LocalDateTime ldtStart = LocalDateTime.parse(request.getParameter("start"), formatter);
        // LocalDateTime in Instant umwandeln
        Instant start = ldtStart.toInstant(ZoneOffset.UTC);

        Instant end = LocalDateTime.parse(request.getParameter("end"), formatter).toInstant(ZoneOffset.UTC);

        CompanyService.createEmployeeInProject(employeeId, projectId, start, end);
    }
}
