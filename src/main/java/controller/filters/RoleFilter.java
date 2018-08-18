package controller.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/admin/*")
public class RoleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String role = (String) httpRequest.getSession().getAttribute("role");
        if (!"admin".equals(role)) {
            httpResponse.sendError(403);
            return;
        } else {
            httpRequest.getRequestDispatcher(httpRequest.getRequestURI()).forward(httpRequest, httpResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
