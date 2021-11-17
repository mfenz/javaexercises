package at.cb.immo.servlet;

import at.cb.immo.model.Immobilie;
import at.cb.immo.service.ImmobilienService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminImmobilienServletServlet", value = "/admin-immobilien")
public class AdminImmobilienServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // Immobilien laden
        List<Immobilie> immobilien = ImmobilienService.getImmobilien();
        // Immobilien in der Request hinzufügen
        request.setAttribute("immobilien", immobilien);

        // zur Ausgabe an ein JSP weiterleiten
        getServletContext().getRequestDispatcher("/admin_immobilien.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }
}
