package controller;

import model.User;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet (name="CreateUserServlet", displayName="CreateUserServlet", urlPatterns = {"/create"})
public class CreateUserServlet extends HttpServlet {

    private User user;
    private UserServiceImpl userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = new User();
        String action = "Create";
        req.setAttribute("string", action);
        String suffix = "new user";
        req.setAttribute("suffix", suffix);
        req.setAttribute("user", user);
        req.getRequestDispatcher("WEB-INF/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        user.setName(req.getParameter("name"));
        user.setPassword(req.getParameter("password"));
        userService.getUserService().add(user);
        resp.sendRedirect("/table");
    }
}
