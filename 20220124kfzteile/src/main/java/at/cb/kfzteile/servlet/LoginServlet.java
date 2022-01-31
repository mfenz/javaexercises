package at.cb.kfzteile.servlet;

import at.cb.kfzteile.model.Benutzer;
import at.cb.kfzteile.service.BenutzerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "LoginServlet", value = "/")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // IP des Users
        String ip = request.getRemoteAddr();

        // Browser des Users
        String browser = request.getHeader("User-Agent");

        // IP und Browser als Request-attribute hinterlegen
        // damit man im JSP darauf zugreifen kann
        request.setAttribute("ip", ip);
        request.setAttribute("browser", browser);

        getServletContext().getRequestDispatcher("/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String passwort = request.getParameter("passwort");

        Optional<Benutzer> optionalBenutzer =
                BenutzerService.login(email, passwort, request.getSession());

        if(optionalBenutzer.isPresent()){
            Benutzer benutzer = optionalBenutzer.get();

            // wenn Benutzer admin ist, in den Admin-Bereich weiterleiten
            if(benutzer.isAdmin()){
                response.sendRedirect("./admin");
                return; // immer nach response.sendRedirect!!!
            } else {
                // oder sonst in den Benutzerbereich weiterleiten
                response.sendRedirect("./benutzer");
                return; // immer nach response.sendRedirect!!!
            }
        } else {
            // Fehlermeldung ausgeben ...
            List<String> errors = new ArrayList<>();
            errors.add("Email / Passwort ungültig!");
            request.setAttribute("errors", errors);

            doGet(request, response);
        }
    }
}
