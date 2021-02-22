package com.company.controller;

import com.company.entity.OrderItems;
import com.company.entity.Orders;
import com.company.entity.OrdersAndOrderItemsAndProduct;
import com.company.entity.Product;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class UserBuy extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uid = req.getParameter("uid");
        System.out.println("uid   "+uid);
        Collection<OrderItems> orderItemsCollection = new ArrayList<>();
        if (!uid.equals("null")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Date date = new Date();
            int oid = (int)(date.getTime()/100000);
            String odate = df.format(date);
            Collection<Product> c = null;
            try {
                c = userService.showAllProd("asc");
            } catch (SQLException throwables) {
                System.out.println("userService.showAllProd    error");
            }
            for (Product prod : c) {
                String pname = prod.getPname();
                String pid = prod.getPid();
                System.out.println("pid   "+pid);
                String str = req.getParameter(pname);
                String price = prod.getPprice();
                int quantity = 0;
                if (!str.equals("") || str != null) {
                    quantity = Integer.parseInt(str);
                }
                int i = Integer.parseInt(prod.getAmount());
                if (quantity > 0) {
                    if (quantity > i) {
                        req.getRequestDispatcher("ShowAllProducts.jsp").forward(req, resp);
                        //购买数大于库存
                    } else {//成功加入购物车
                        orderItemsCollection.add(new OrderItems(oid, pid, quantity));
                    }
                }
            }

            //订单表插入数据  订单详情表插入数据
            try {
                userService.shop(new Orders(odate, uid, oid), orderItemsCollection);
                Collection<OrdersAndOrderItemsAndProduct> prods = userService.showCart(uid);
                req.setAttribute("uid", uid);
                req.setAttribute("prods", prods);
                for (OrdersAndOrderItemsAndProduct  o:prods
                     ) {
                    System.out.println( "-------OrdersAndOrderItemsAndProduct---" + o);
                }

                req.getRequestDispatcher("WEB-INF/jsp/user/Cart.jsp").forward(req, resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("error lgo");
            req.getRequestDispatcher("UserLogin.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
