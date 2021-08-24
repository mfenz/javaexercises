package at.cb.empdept.filter;

import at.cb.empdept.servlet.LoginServlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/profile", "/logout", "/createdepartment"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException
            , IOException {

        // Prüfen ob User angemeldet ist

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        // Session holen
        HttpSession session = httpRequest.getSession();

        // Prüfen ob logged_in vorhanden, und true ist
        if(session.getAttribute(LoginServlet.SESSION_LOGGED_IN) == null
                || !(boolean)session.getAttribute(LoginServlet.SESSION_LOGGED_IN)){

            // User nicht angemeldet! Weiterleiten zum Login
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("./login");
            return;
        }

        // Vor dem Servlet-Aufruf
        chain.doFilter(request, response);
        // Nach dem Servlet-Aufruf

    }
}
