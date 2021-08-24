package at.cb.empdept.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        getServletContext().getRequestDispatcher("/logout.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        //
        request.getSession().setAttribute(LoginServlet.SESSION_LOGGED_IN, false);
        request.getSession().setAttribute(LoginServlet.SESSION_USER_ID, null);

        // Session löschen
        request.getSession().invalidate();

        // Redirect auf die Startseite
        response.sendRedirect("./");
    }
}
