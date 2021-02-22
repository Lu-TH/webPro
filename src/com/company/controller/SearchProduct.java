package com.company.controller;

import com.company.entity.Product;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 搜索商品
 */
public class SearchProduct extends HttpServlet {
    UserService userService = new UserServiceImpl();
    Collection<Product> products = null;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ptype = req.getParameter("search");

        try {
            products = userService.showProduct(ptype);
            req.setAttribute("products", products);
            req.getRequestDispatcher("ShowOneProducts.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String order = req.getParameter("order");

        String uid = req.getParameter("uid");
        try {
            if(order.equals("asc")){
                products = userService.showAllProd(order);
            }else {
                products = userService.showAllProductDesc();
            }
            req.setAttribute("allProducts", products);
            req.setAttribute("uid", uid);
            req.getRequestDispatcher("ShowAllProducts.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
