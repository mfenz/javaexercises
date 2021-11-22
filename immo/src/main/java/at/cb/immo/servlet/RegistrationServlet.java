package at.cb.immo.servlet;

import at.cb.immo.service.ServiceException;
import at.cb.immo.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RegistrationServlet", value = "/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // Weiterleitung zum JSP
        // Request Dispatcher
        getServletContext().getRequestDispatcher("/register.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // Wurde der Button gedrückt?
        if(request.getParameter("btsubmit") != null){
            // Parameter einlesen
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            // Parameter prüfen
            List<String> errors = new ArrayList<>();

            if(name == null || name.isEmpty()){
                errors.add("Name eingeben");
            }
            if(email == null || email.isEmpty()){
                errors.add("Email eingeben");
            }
            if(password == null || password.isEmpty()){
                errors.add("Passwort eingeben");
            } else if(password.length() < 6){
                errors.add("Passwort muss mind. 6 Zeichen haben");
            }

            if(errors.isEmpty()){
                // User anlegen
                try {
                    // Registrierung durchführen
                    int userId = UserService.createUser(name, email, password);
                    // zum Login weiterleiten
                    response.sendRedirect("./login?userid="+userId);
                    return;
                } catch (ServiceException e){
                    e.printStackTrace();
                    errors.add(e.getMessage());
                }
            }

            // Fehler als Request Attribute hinterlegen
            request.setAttribute("errors", errors);
            // JSP anzeigen
            getServletContext().getRequestDispatcher("/register.jsp")
                    .forward(request, response);
        }
    }
}
