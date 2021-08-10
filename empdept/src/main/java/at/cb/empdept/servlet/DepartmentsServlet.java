package at.cb.empdept.servlet;

import at.cb.empdept.model.Department;
import at.cb.empdept.service.CompanyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartmentsServlet", value = "/departments")
public class DepartmentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // departments laden
        List<Department> departments = CompanyService.getDepartments();
        // für die Weitergabe an JSP: Liste von Departments als Attribute hinterlegen
        request.setAttribute("departments", departments);
        getServletContext().getRequestDispatcher("/departments.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }
}
