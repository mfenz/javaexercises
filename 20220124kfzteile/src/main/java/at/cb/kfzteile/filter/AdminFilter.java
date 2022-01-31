package at.cb.kfzteile.filter;

import at.cb.kfzteile.service.BenutzerService;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter", urlPatterns = {"/admin", "/admin*"})
public class AdminFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // Ist User (als Admin) angemeldet?
        if(!BenutzerService.isAdmin(httpServletRequest.getSession())){
            // redirect auf die Startseite
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendRedirect("./");
            return;
        }

        // vor dem eigentlichen Seitenaufruf ausgeführt
        chain.doFilter(request, response);
        // nach dem eigentlichen Seitenaufruf ausgeführt
    }
}
