package at.cb.empdept.servlet;

import at.cb.empdept.model.Department;
import at.cb.empdept.service.CompanyService;
import at.cb.empdept.service.ServiceInputException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateEmployeeServlet", value = "/createemployee")
public class CreateEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // Departments laden
        List<Department> departments = CompanyService.getDepartments();
        // Department-Liste als Request-Attribute setzen
        request.setAttribute("departments", departments);

        getServletContext().getRequestDispatcher("/create_employee.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        float salary = Float.parseFloat(request.getParameter("salary"));
        int departmentId = Integer.parseInt(request.getParameter("department_id"));

        try {
            int employeeId = CompanyService.createEmployee(firstname, lastname, salary, departmentId);
            response.sendRedirect("./?employeeid="+employeeId);
        } catch (ServiceInputException e) {
            e.printStackTrace();
        }
    }
}
