package at.cb.kfzteile.filter;

import at.cb.kfzteile.service.BenutzerService;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "BenutzerFilter", urlPatterns = {"/benutzer/", "/benutzer/*"})
public class BenutzerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // Ist User angemeldet?
        if(!BenutzerService.isLoggedIn(httpServletRequest.getSession())){
            // redirect auf die Startseite
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendRedirect("./");
            return;
        }

        chain.doFilter(request, response);
    }
}
