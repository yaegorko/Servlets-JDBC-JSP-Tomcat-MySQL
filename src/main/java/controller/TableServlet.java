package controller;

import model.User;
import service.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TableServlet", displayName = "TableServlet", urlPatterns = {"/table"})
public class TableServlet extends HttpServlet {

    private UserServiceImpl userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = userService.getUserService().getAllUsers();
        req.setAttribute("list", list);
        req.getRequestDispatcher("WEB-INF/table.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String delete = req.getParameter("delete");
        String update = req.getParameter("update");
        if ("Add new user".equals(action)) {
            resp.sendRedirect("/create");
        }
        if (delete != null) {
            userService.getUserService().deleteUser(Integer.parseInt(delete));
            resp.sendRedirect("/table");
        }
        if (update != null) {
            req.getRequestDispatcher("/update").forward(req, resp);
        }
    }

}
