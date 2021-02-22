package com.company.controller;

import com.company.dao.ManagerDao;
import com.company.entity.OrderItems;
import com.company.service.ManagerService;
import com.company.service.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class OrderItemsUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oid = req.getParameter("oid");
        String pid = req.getParameter("pid");
        String quantity = req.getParameter("quantity");
        int fk_oid = Integer.parseInt(oid);
        int qua = Integer.parseInt(quantity);
        ManagerService managerService = new ManagerServiceImpl();
        try {
            managerService.modOrders(new OrderItems(fk_oid, pid, qua));
            req.getRequestDispatcher("WEB-INF/jsp/manager/ManagerIndex.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
