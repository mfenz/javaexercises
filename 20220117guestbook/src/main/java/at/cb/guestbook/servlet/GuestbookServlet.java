package at.cb.guestbook.servlet;

import at.cb.guestbook.model.GuestbookEntry;
import at.cb.guestbook.service.GuestbookService;
import at.cb.guestbook.service.ServiceException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 *
 */
@WebServlet(name = "GuestbookServlet", value = "/")
public class GuestbookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Lade alle GuestbookEntries
        List<GuestbookEntry> guestbookEntries = GuestbookService.getGuestbookEntries();
        request.setAttribute("entries", guestbookEntries);

        String ip = request.getRemoteAddr();
        request.setAttribute("ip", ip);

        String browser = request.getHeader("User-Agent");
        request.setAttribute("browser", browser);

        // Zur Ausgabe an ein JSP weiterleiten
        getServletContext()
                .getRequestDispatcher("/guestbook.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Einlesen der übertragenen Werte aus dem Formular
        // getParameter(so wie es im HTML name genannt wurde)
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String text = request.getParameter("text");

        request.setAttribute("form_name", name);
        request.setAttribute("form_email", email);
        request.setAttribute("form_text", text);

        // Gästebucheintrag speichern
        try {
            int id = GuestbookService.createGuestbookEntry(name, email, text);

            // Seite neu laden, von POST-Request auf GET-Request
            response.sendRedirect("./?created=true&entryid="+id);
        } catch (ServiceException e){
            request.setAttribute("error", e.getMessage());
            doGet(request, response);
        }

    }
}
