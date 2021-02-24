package com.company.controller;

import com.company.entity.User;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 修改用户信息
 */
public class ModUserInfo extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        User user = new User();
        try {
            List<FileItem> list = servletFileUpload.parseRequest(req);
            FileItem file0 = list.get(0);
            FileItem file1 = list.get(1);//图片待上传
            FileItem file2 = list.get(2);
            FileItem file3 = list.get(3);
            FileItem file4 = list.get(4);

            String uid = file0.getString();
            String uname = file2.getString();
            String uphone = file3.getString();
            String uaddress = file4.getString();
            if(file1 != null || !file1.equals("null")){
                String newFileName = file1.getName();
                String[] arr = newFileName.split("\\.");//.是特殊字符
                String res = "." + arr[1];
                String destinationPath = "C:\\img\\";
                destinationPath = destinationPath + uid + res;//"C:\\img\\xxx.xxx"

                String logo = "/images/" + uid + res;
                System.out.println(logo);
                File newFile = new File(destinationPath);
                file1.write(newFile);
                user.setUlogo(logo);
            }

            user.setUid(uid);
            user.setUphone(uphone);
            user.setUname(uname);
            user.setUaddress(uaddress);

            userService.changeInfo(user);

            req.setAttribute("userObj", user);

            req.getRequestDispatcher("WEB-INF\\jsp\\user\\UserInfomation.jsp").forward(req, resp);
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String uname = req.getParameter("uname");
        String uphone = req.getParameter("uphone");
        String uaddress = req.getParameter("uaddress");
        User user = new User();
        user.setUaddress(uaddress);
        user.setUname(uname);
        user.setUphone(uphone);
        user.setUid(uid);
        try {
            userService.changeInfo(user);
            req.getRequestDispatcher("WEB-INF/jsp/manager/ManagerIndex.jsp").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
