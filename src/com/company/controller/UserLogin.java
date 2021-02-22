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

/**
 * 用户登录
 */
public class UserLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String pwd = req.getParameter("pwd");
        UserService userService = new UserServiceImpl();
        try {
            String truePwd = userService.login(uid);
            if(truePwd.equals("")){//密码为空字符串 用户名不存在 重新输入
                req.setAttribute("errorUid", "用户名不存在");
                req.getRequestDispatcher("UserLogin.jsp").forward(req, resp);
            }else if(truePwd.equals(pwd)){//登录成功 推入购物车

               // Collection<OrdersAndOrderItemsAndProduct> result = userService.showCart(uid);
                req.setAttribute("uid", uid);
                //req.setAttribute("desc", result);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }else{//密码错误 重新输入
                req.setAttribute("errorPwd", "密码错误");
                req.getRequestDispatcher("UserLogin.jsp").forward(req, resp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
