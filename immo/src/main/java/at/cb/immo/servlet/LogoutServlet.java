package at.cb.immo.servlet;

import at.cb.immo.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        getServletContext().getRequestDispatcher("/logout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        if(request.getParameter("btsubmit") != null){
            UserService.logout(request.getSession());
            response.sendRedirect("./login");
        }
    }
}
