package at.cb.empdept.servlet;

import at.cb.empdept.service.CompanyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateDepartmentServlet", value =
        "/createdepartment")
public class CreateDepartmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // Zur Ausgabe an JSP weiterleiten
        getServletContext().getRequestDispatcher("/create_department.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int departmentId = CompanyService.createDepartment(name);
        // Weiterleiten zum Index, ID der neuen Abteilung übergeben als GET-Parameter
        response.sendRedirect("./?departmentid="+departmentId);
        return;
    }
}
