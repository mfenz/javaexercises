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
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StatisticsServlet", value = "/statistics")
public class StatisticsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.print("<body>");

        Map<Department, List<Employee>> employeesInDepartments =
                CompanyService.getEmployeesByDepartment();

        writer.println("<h1>Employees grouped by department</h1>");
        employeesInDepartments.forEach((department, employees) -> {
            // Department name ausgeben
            writer.println("<h2>" + department.getName() + "</h2>");

            // Mitarbeiter des departments ausgeben
            employees.
                    forEach(emp ->
                            writer.printf("<p>%s %s %.2f</p>", emp.getFirstname(), emp.getLastname(), emp.getSalary()));
        });

        writer.println("<h1>Salaries by department</h1>");
        Map<Department, Double> salariesByDepartment = CompanyService.getSalariesByDepartment();
        salariesByDepartment.forEach(
                (department, salaries) ->
                        writer.printf("<p>%s %.2f</p>", department.getName(), salaries));

        writer.print("</body>");

    }
}
