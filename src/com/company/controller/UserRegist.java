package com.company.controller;

import com.company.entity.User;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 用户注册
 */
public class UserRegist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String pwd = req.getParameter("pwd");
        String phone = req.getParameter("phone");
        User user = new User(uid, pwd, phone);
        UserService userService = new UserServiceImpl();
        try {
            userService.regist(user);
            //注册成功 跳转到登录页面
            req.getRequestDispatcher("UserLogin.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            //uid已存在错误
            req.setAttribute("errorUid", "用户名已存在");
            req.getRequestDispatcher("UserRegist.jsp").forward(req, resp);//重新注册
        }
    }
}
