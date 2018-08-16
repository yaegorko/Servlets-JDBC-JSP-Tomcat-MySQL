package controller;

import dao.UserDaoImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", displayName = "UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {

    User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String s = req.getParameter("update");
        if (s != null) {
            String string = "Update";
            req.setAttribute("string", string);
            String suffix = "user";
            req.setAttribute("suffix", suffix);
            user = UserDaoImpl.getUserById(Integer.parseInt(s));
            req.setAttribute("user", user);
            req.getRequestDispatcher("WEB-INF/create.jsp").forward(req, resp);
        } else {
            user.setName(req.getParameter("name"));
            user.setPassword(req.getParameter("password"));
            UserDaoImpl.updateUser(user);
            resp.sendRedirect("/table");
        }
    }
}
