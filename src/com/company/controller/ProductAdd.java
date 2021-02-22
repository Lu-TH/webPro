package com.company.controller;

import com.company.entity.Product;
import com.company.service.ManagerService;
import com.company.service.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ProductAdd extends HttpServlet {
    ManagerService managerService = new ManagerServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        String pname = req.getParameter("pname");
        String pprice = req.getParameter("pprice");
        String amount = req.getParameter("amount");
        String ptype = req.getParameter("ptype");
        try {
            managerService.addProduct(new Product(pid, pname, pprice, amount, ptype));
            System.out.println("ADD");
            req.getRequestDispatcher("WEB-INF/jsp/manager/ManagerIndex.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        String pname = req.getParameter("pname");
        String pprice = req.getParameter("pprice");
        String amount = req.getParameter("amount");
        String ptype = req.getParameter("ptype");
        try {
            managerService.modProduct(new Product(pid, pname, pprice, amount, ptype));
            System.out.println("update");
            req.getRequestDispatcher("WEB-INF/jsp/manager/ManagerIndex.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
