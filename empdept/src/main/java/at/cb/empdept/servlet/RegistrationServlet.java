package at.cb.empdept.servlet;

import at.cb.empdept.service.ServiceInputException;
import at.cb.empdept.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        getServletContext().getRequestDispatcher("/user_registration.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            int userId = UserService.createUser(email, password);
            // Auf Login-Seite weiterleiten
            response.sendRedirect("./login?userid="+userId);
            return;

        } catch (ServiceInputException e){
            // Fehlermeldung als Attribute setzen
            request.setAttribute("error", e.getMessage());
            // an Registrierungs-Seite weiterleiten (zur Darstellung der Fehlermeldung)
            getServletContext().getRequestDispatcher("/user_registration.jsp").forward(request, response);
            return;
        }

    }
}
