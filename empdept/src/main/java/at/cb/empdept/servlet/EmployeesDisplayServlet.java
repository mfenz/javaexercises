package at.cb.empdept.servlet;

import at.cb.empdept.dao.DbConnection;
import at.cb.empdept.dao.EmployeeDAO;
import at.cb.empdept.model.Employee;
import at.cb.empdept.service.CompanyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeesDisplayServlet", value = "/employees")
public class EmployeesDisplayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // Employees laden
        List<Employee> employees = CompanyService.getEmployees();

        // Request-Attribut setzen (um im JSP auf die Liste zugreifen zu können)
        request.setAttribute("employees", employees);

        // Anfrage an JSP weiterreichen
        getServletContext().getRequestDispatcher("/display_employees.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }
}
