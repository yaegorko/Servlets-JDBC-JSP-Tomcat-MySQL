package controller.filters;

import model.User;
import service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/accept")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String userName = httpRequest.getParameter("user").trim();
        String userPassword = httpRequest.getParameter("password").trim();
        User user = UserServiceImpl.getUserService().getByName(userName);
        String passwordFromBase = user.getPassword().trim();
        if (passwordFromBase.equals(userPassword)) {
            httpRequest.getSession().setAttribute("role", user.getRole());
            httpRequest.getRequestDispatcher("/accept").forward(servletRequest, servletResponse);
        } else {
            httpResponse.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }
}
