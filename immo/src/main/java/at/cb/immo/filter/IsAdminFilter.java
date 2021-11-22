package at.cb.immo.filter;

import at.cb.immo.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "IsAdminFilter", urlPatterns = {"/admin", "/admin*"})
public class IsAdminFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException
            , IOException {
        System.out.println("Admin Filter wird ausgeführt");
        // Ist User ein Admin (und angemeldet)?
        HttpSession session = ((HttpServletRequest)request).getSession();
        if(!UserService.isAdmin(session)){
            // Redirect auf die Startseite
            ((HttpServletResponse)response).sendRedirect("./");
            return;
        }
        chain.doFilter(request, response);
    }
}
