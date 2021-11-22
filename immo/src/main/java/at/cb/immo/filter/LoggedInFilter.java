package at.cb.immo.filter;

import at.cb.immo.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoggedInFilter", urlPatterns = "/*")
public class LoggedInFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException
            , IOException {
        HttpSession session = ((HttpServletRequest)request).getSession();
        request.setAttribute(UserService.SESSION_LOGGED_IN, UserService.isLoggedIn(session));
        request.setAttribute(UserService.SESSION_ADMIN, UserService.isAdmin(session));
        chain.doFilter(request, response);

    }
}
