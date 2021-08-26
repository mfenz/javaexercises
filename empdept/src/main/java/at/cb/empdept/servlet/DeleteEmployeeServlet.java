package at.cb.empdept.servlet;

import at.cb.empdept.service.CompanyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteEmployeeServlet", value = "/deleteemployee")
public class DeleteEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));

        boolean success = CompanyService.deleteEmployee(employeeId);
        if(success){
            response.sendRedirect("./employees");
            return;
        }
        response.getWriter().println("Fehler beim Löschen.");
    }
}
