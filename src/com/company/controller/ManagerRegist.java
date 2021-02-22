package com.company.controller;

import com.company.entity.Manager;
import com.company.service.ManagerService;
import com.company.service.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 管理员注册
 */
public class ManagerRegist extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mid = req.getParameter("mid");
        String pwd = req.getParameter("pwd");
        String mname = req.getParameter("mname");
        ManagerService managerService = new ManagerServiceImpl();
        try {
            managerService.regist(new Manager(mid, mname, pwd));
            req.getRequestDispatcher("ManagerLogin.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
