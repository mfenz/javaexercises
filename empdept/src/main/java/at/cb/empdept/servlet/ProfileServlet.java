package at.cb.empdept.servlet;

import at.cb.empdept.model.User;
import at.cb.empdept.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // User-ID aus der Session auslesen
        int userId = (int)request.getSession().getAttribute(LoginServlet.SESSION_USER_ID);

        // User anhand der ID aus der Datenbank laden
        Optional<User> optionalUser = UserService.getUserById(userId);
        if(optionalUser.isPresent()){
            request.setAttribute("user", optionalUser.get());
        }

        getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

    }
}
