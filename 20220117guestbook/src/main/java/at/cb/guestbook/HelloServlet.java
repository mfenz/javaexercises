package at.cb.guestbook;

import at.cb.guestbook.dao.GuestbookEntryDao;
import at.cb.guestbook.model.GuestbookEntry;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        GuestbookEntryDao.createGuestbookEntry(new GuestbookEntry(0, "Hansi", "h@b.at", "Hallo"));

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}