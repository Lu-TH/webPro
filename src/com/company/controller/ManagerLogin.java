package com.company.controller;

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

public class ManagerLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mid = req.getParameter("mid");
        String pwd = req.getParameter("pwd");
        ManagerService managerService = new ManagerServiceImpl();
        try {
            String truePwd = managerService.login(mid);
            if(truePwd.equals("")){//密码为空字符串 用户名不存在 重新输入
                System.out.println("error1");
                req.getRequestDispatcher("ManagerLogin.jsp").forward(req, resp);
            }else if(truePwd.equals(pwd)){//登录成功 推入购买页面
                System.out.println("管理员登录");
                req.setAttribute("mid", mid);
                req.getRequestDispatcher("WEB-INF/jsp/manager/ManagerIndex.jsp").forward(req, resp);
            }else{//密码错误 重新输入
                System.out.println("error2");
                req.getRequestDispatcher("ManagerLogin.jsp").forward(req, resp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
