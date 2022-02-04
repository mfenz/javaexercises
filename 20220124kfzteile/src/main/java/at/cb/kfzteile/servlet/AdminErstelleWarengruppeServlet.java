package at.cb.kfzteile.servlet;

import at.cb.kfzteile.model.Benutzer;
import at.cb.kfzteile.model.Warengruppe;
import at.cb.kfzteile.service.BenutzerService;
import at.cb.kfzteile.service.WarengruppenService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "AdminErstelleWarengruppeServlet", value = "/admin/erstellewarengruppe")
public class AdminErstelleWarengruppeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lade alle Mitarbeiter die Leiter einer Warengruppe sein könnten
        List<Benutzer> mitarbeiter = BenutzerService.getMitarbeiter();
        request.setAttribute("mitarbeiter", mitarbeiter);

        getServletContext()
                .getRequestDispatcher("/admin_erstelle_warengruppe.jsp")
                .forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bezeichnung = request.getParameter("bezeichnung");
        int leiterId = Integer.parseInt(request.getParameter("leiter"));
        Optional<Benutzer> optionalBenutzer = BenutzerService.getBenutzerById(leiterId);
        if(optionalBenutzer.isPresent()){

            Warengruppe warengruppe = new Warengruppe(0, optionalBenutzer.get(), bezeichnung, new ArrayList<>());
            int id = WarengruppenService.createWarengruppe(warengruppe);
            response.sendRedirect("./created=true&id="+id);
            return;
        }

        List<String> errors = new ArrayList<>();
        request.setAttribute("errors", errors);
        doGet(request, response);
        return;
    }
}
