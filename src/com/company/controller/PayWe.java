package com.company.controller;

import com.company.service.UserService;
import com.company.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class PayWe extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int oid = Integer.parseInt(req.getParameter("oid"));
        try {
            userService.checkBug(oid);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
