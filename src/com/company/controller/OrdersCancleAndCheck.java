package com.company.controller;

import com.company.entity.Orders;
import com.company.service.ManagerService;
import com.company.service.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class OrdersCancleAndCheck extends HttpServlet {
    ManagerService managerService = new ManagerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int oid = Integer.parseInt(req.getParameter("oid"));
        try {
            Orders orders = managerService.showOrders(oid);
            req.setAttribute("ordersObj", orders);
            req.getRequestDispatcher("WEB-INF/jsp/ShowOrders.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int oid = Integer.parseInt(req.getParameter("oid"));
        try {
            managerService.modOrders(oid);
            req.getRequestDispatcher("WEB-INF/jsp/manager/ManagerIndex.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
