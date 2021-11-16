package at.cb.immo.servlet;

import at.cb.immo.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // JSP aufrufen
        getServletContext()
                .getRequestDispatcher("/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // Parameterüberprüfung
        List<String> errors = new ArrayList<>();
        request.setAttribute("errors", errors);
        if(email == null || email.isEmpty()){
            errors.add("E-Mail eingeben");
        }
        if(password == null || password.isEmpty()){
            errors.add("Passwort eingeben");
        }

        // Überprüfung und Login im Service
        if(errors.isEmpty()){
            if(UserService.login(email, password, request.getSession())){
                // login erfolgreich
                response.sendRedirect("./");
                return;
            } else {
                errors.add("Logindaten überprüfen");
                // JSP darstellen
                doGet(request, response);
                return;
            }
        }
        doGet(request, response);
    }
}
