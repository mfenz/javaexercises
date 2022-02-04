package at.cb.kfzteile.servlet;

import at.cb.kfzteile.service.BenutzerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BenutzerUpdatePasswortServlet", value = "/benutzer/updatepasswort")
public class BenutzerUpdatePasswortServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = BenutzerService.getCurrentUserId(request.getSession());
        String neuesPasswort = request.getParameter("passwort");

        BenutzerService.updatePasswort(userId, neuesPasswort);

        response.sendRedirect("./?passwordchanged=true");
        return;
    }
}
