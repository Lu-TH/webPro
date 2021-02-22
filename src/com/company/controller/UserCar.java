package com.company.controller;

import com.company.entity.OrdersAndOrderItemsAndProduct;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

public class UserCar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        UserService userService = new UserServiceImpl();
        Collection<OrdersAndOrderItemsAndProduct> c = null;
        try {
            c = userService.showCart(uid);
            req.setAttribute("products", c);
            req.getRequestDispatcher("WEB-INF/jsp/user/Car.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
