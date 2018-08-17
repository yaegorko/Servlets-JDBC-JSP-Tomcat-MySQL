package controller;

import model.User;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", displayName = "UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {

    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String string = "Update";
        req.setAttribute("string", string);
        String suffix = "user";
        req.setAttribute("suffix", suffix);
        String s = req.getParameter("update");
        user = UserServiceImpl.getUserService().getById(Integer.parseInt(s));
        req.setAttribute("user", user);
        req.getRequestDispatcher("WEB-INF/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        user.setName(req.getParameter("name"));
        user.setPassword(req.getParameter("password"));
        UserServiceImpl.getUserService().updateUser(user);
        resp.sendRedirect("/table");

    }
}
