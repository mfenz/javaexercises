package at.cb.kfzteile.servlet;

import at.cb.kfzteile.model.Benutzer;
import at.cb.kfzteile.model.Rolle;
import at.cb.kfzteile.service.BenutzerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "CreateFirstAdminServlet", value = "/createfirstadmin")
public class CreateFirstAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(true){
            response.getWriter().println("Admin bereits erstellt?");
            return;
        }
        List<Rolle> rollen = new ArrayList<>();
        rollen.add(new Rolle(1, "Admin"));
        rollen.add(new Rolle(2, "User"));
        Benutzer admin = new Benutzer(0, "Marc", "F",
                "email@email.com", "123456", Optional.empty(),
                rollen, Optional.empty());
        int userId = BenutzerService.createBenutzer(admin);
        response.getWriter().println("Admin erstellt! ID: " + userId);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
