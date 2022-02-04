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

@WebServlet(name = "AdminBearbeiteBenutzerServlet", value = "/admin/benutzerbearbeiten")
public class AdminBearbeiteBenutzerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Benutzer laden (anhand der ID als GET-Parameter)
        int benutzerId = Integer.parseInt(request.getParameter("id"));

        List<Warengruppe> warengruppen = WarengruppenService.getWarengruppen();
        request.setAttribute("warengruppen", warengruppen);

        Benutzer benutzer = BenutzerService
                .getBenutzerById(benutzerId)
                .orElseThrow(() ->  new RuntimeException("Benutzer nicht gefunden"));
        request.setAttribute("benutzer", benutzer);

        getServletContext()
                .getRequestDispatcher("/admin_bearbeite_benutzer.jsp")
                .forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Welcher Benutzer wird bearbeitet?
        int id = Integer.parseInt(request.getParameter("id"));

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


        // Aktuelles Benutzer-Objekt laden
        Benutzer benutzer = BenutzerService.getBenutzerById(id).orElseThrow(
                () -> new RuntimeException("Benutzer nicht gefundeb"));

        benutzer.setVorname(vorname);
        benutzer.setNachname(nachname);
        benutzer.setEmail(email);
        benutzer.setPasswort(passwort);
        benutzer.setWarengruppeId(warengruppeId);
        benutzer.setRollen(rollen);
        benutzer.setInteressent(interessent);

        BenutzerService.updateBenutzer(benutzer);

        response.sendRedirect("./?updated=true");
        return;
    }
}
