package at.cb.kfzteile.servlet;

import at.cb.kfzteile.model.Benutzer;
import at.cb.kfzteile.model.Warengruppe;
import at.cb.kfzteile.service.BenutzerService;
import at.cb.kfzteile.service.WarengruppenService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BenutzerServlet", value = "/benutzer/")
public class BenutzerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Benutzer benutzer = BenutzerService
                .getBenutzerById(BenutzerService.getCurrentUserId(request.getSession()))
                .orElseThrow(() -> new RuntimeException("User nicht gefunden"));

        // Gibt es eine Warengruppe?
        if(benutzer.getWarengruppeId().isPresent()){
            // lade Warengruppe
            Warengruppe warengruppe = WarengruppenService
                    .getWarengruppeById(benutzer.getWarengruppeId().get())
                    .orElseThrow(() -> new RuntimeException("Warengruppe nicht gefunden"));
            request.setAttribute("warengruppe", warengruppe);
        }

        request.setAttribute("benutzer", benutzer);

        getServletContext().getRequestDispatcher("/benutzer.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
