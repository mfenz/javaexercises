package at.cb.empdept.servlet;

import at.cb.empdept.model.User;
import at.cb.empdept.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    public static final String SESSION_LOGGED_IN = "logged_in";
    public static final String SESSION_USER_ID = "user_id";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Optional<User> optionalUser = UserService.login(email, password);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();

            // User-Information in Session speichern
            HttpSession session = request.getSession();
            session.setAttribute(SESSION_LOGGED_IN, true);
            session.setAttribute(SESSION_USER_ID, user.getId());

            // auf Profil-Seite weiterleiten
            response.sendRedirect("./profile");
            return;
        } else {
            // Fehlermeldung setzen
            request.setAttribute("error", "Anmeldedaten prüfen");
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
    }
}
