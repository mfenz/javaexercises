package at.cb.kfzteile.servlet;

import at.cb.kfzteile.model.Benutzer;
import at.cb.kfzteile.model.Interessent;
import at.cb.kfzteile.model.Rolle;
import at.cb.kfzteile.model.Warengruppe;
import at.cb.kfzteile.service.BenutzerService;
import at.cb.kfzteile.service.RollenService;
import at.cb.kfzteile.service.WarengruppenService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "AdminErstelleBenutzerServlet", value = "/admin/benutzererstellen")
public class AdminErstelleBenutzerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Warengruppe> warengruppen = WarengruppenService.getWarengruppen();
        request.setAttribute("warengruppen", warengruppen);

        getServletContext().getRequestDispatcher("/admin_erstelle_benutzer.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vorname = request.getParameter("vorname");
        String nachname = request.getParameter("nachname");
        String email = request.getParameter("email");
        String passwort = request.getParameter("passwort");
        String warengruppe = request.getParameter("warengruppe");
        boolean isAdmin = request.getParameter("admin") != null;
        String benutzerTyp = request.getParameter("benutzertyp");

        // Daten für Interessent
        String strasse = request.getParameter("strasse");
        String plz = request.getParameter("plz");
        String ort = request.getParameter("ort");
        String firmenname = request.getParameter("firmenname");

        // Warengruppe gegeben?
        Optional<Integer> warengruppeId = Optional.empty();
        if (!warengruppe.equals("")) {
            warengruppeId = Optional.of(Integer.parseInt(warengruppe));
        }

        Optional<Interessent> interessent = Optional.empty();
        List<Rolle> rollen = new ArrayList<>();
        if (isAdmin) {
            rollen.add(RollenService.getRolleById(1).get());
        }
        if (benutzerTyp.equals("mitarbeiter")) {
            rollen.add(RollenService.getRolleById(2).get());
        } else if (benutzerTyp.equals("interessent")) {
            rollen.add(RollenService.getRolleById(3).get());

            interessent = Optional.of(new Interessent(strasse, plz, ort, firmenname));
        }


        Benutzer benutzer = new Benutzer(0, vorname, nachname, email, passwort, warengruppeId,
                rollen, interessent);
        int benutzerId = BenutzerService.createBenutzer(benutzer);

        response.sendRedirect("./?created?true&id=" + benutzerId);
        return;
    }
}
