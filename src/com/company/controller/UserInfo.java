package com.company.controller;

import com.company.entity.Manager;
import com.company.entity.User;
import com.company.service.ManagerService;
import com.company.service.ManagerServiceImpl;
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
 * 获取用户信息
 */
public class UserInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ManagerService managerService = new ManagerServiceImpl();
        Collection<User> users = null;
        try {
            users = managerService.showUsers();
            req.setAttribute("users", users);
            req.getRequestDispatcher("WEB-INF/jsp/ShowUsers.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        UserService userService = new UserServiceImpl();
        try {
            //将查询到的user对象推到WEB-INF/jsp/user/UserInfomation.jsp展示
            User user = userService.showUser(uid);
            user.setUid(uid);
            req.setAttribute("userObj", user);
            req.getRequestDispatcher("WEB-INF/jsp/user/UserInfomation.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
