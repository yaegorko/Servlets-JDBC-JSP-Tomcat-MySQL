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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = UserServiceImpl.getUserService().getAllUsers();
        req.setAttribute("list", list);
        req.getRequestDispatcher("WEB-INF/table.jsp").forward(req, resp);
    }
}
