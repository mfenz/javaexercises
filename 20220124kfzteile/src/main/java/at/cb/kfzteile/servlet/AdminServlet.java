package at.cb.kfzteile.servlet;

import at.cb.kfzteile.model.Benutzer;
import at.cb.kfzteile.model.Warengruppe;
import at.cb.kfzteile.service.BenutzerService;
import at.cb.kfzteile.service.WarengruppenService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "AdminServlet", value = "/admin/")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * Aktueller Benutzer
         */
        Optional<Benutzer> optionalBenutzer = BenutzerService.getBenutzerById(
                BenutzerService.getCurrentUserId(request.getSession()));
        if(optionalBenutzer.isPresent()){
            // Benutzer hinterlegen damit es im JSP dargestellt werden kann
            request.setAttribute("current_benutzer", optionalBenutzer.get());
        }

        /**
         * Alle Benutzer
         */
        List<Benutzer> benutzer = BenutzerService.getBenutzer();
        request.setAttribute("benutzer", benutzer);

        /**
         * Alle Mitarbeiter
         */
        List<Benutzer> mitarbeiter = BenutzerService.getMitarbeiter();
        request.setAttribute("mitarbeiter", mitarbeiter);

        /**
         * Alle Administratoren
         */
        List<Benutzer> administratoren = BenutzerService.getAdministratoren();
        request.setAttribute("administratoren", administratoren);

        /**
         * Alle Warengruppen
         */
        List<Warengruppe> warengruppen = WarengruppenService.getWarengruppen();
        request.setAttribute("warengruppen", warengruppen);


        getServletContext().getRequestDispatcher("/admin.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
