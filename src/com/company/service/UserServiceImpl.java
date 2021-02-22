package com.company.service;

import com.company.dao.*;
import com.company.entity.*;

import java.sql.SQLException;
import java.util.Collection;

/**
 * 用户业务实现
 */
public class UserServiceImpl implements UserService{
    UserDao userDao = new UserDaoImpl();
    OrdersDao ordersDao = new OrdersDaoImpl();
    OrderItemsDao orderItemsDao = new OrderItemsDaoImpl();
    ProductDao productDao = new ProductDaoImpl();
    OrdersAndOrderItemsAndProductDao ordersAndOrderItemsAndProductDao = new OrdersAndOrderItemsAndProductDaoImpl();

    @Override
    public void regist(User user) throws SQLException {//注册
        userDao.insert(user);
    }

    @Override
    public String login(String uid) throws SQLException {//登录
        return userDao.selectPwd(uid);
    }

    @Override
    public Collection<OrdersAndOrderItemsAndProduct> showCart(String uid) throws SQLException {
        return ordersAndOrderItemsAndProductDao.showArrearageOrder(uid);
    }

    @Override
    public void shop(Orders orders, Collection<OrderItems> orderItemsCollection) throws SQLException {//购买 orders表添加一条数据后再添加orderitems表中的数据
        ordersDao.insert(orders);//orders表添加数据
        for (OrderItems oi:orderItemsCollection//遍历购物车
             ) {
            orderItemsDao.insert(oi);//order_items表添加数据
        }
    }

    @Override
    public Collection<Product> showProduct(String ptype) throws SQLException {//查看特定类型商品
        return productDao.select(ptype);
    }

    @Override
    public User showUser(String uid) throws SQLException {//查看个人信息
        return userDao.selectInfo(uid);
    }

    @Override
    public Collection<OrdersAndOrderItemsAndProduct> showOrders(String uid) throws SQLException {//查看个人订单
        return ordersAndOrderItemsAndProductDao.showOrdersInfo(uid);
    }

    @Override
    public void changeInfo(User user) throws SQLException {//修改个人信息
        userDao.update(user);
    }

    @Override
    public Collection<Product> showAllProd(String ascOrDesc) throws SQLException {
        return productDao.selectAllAsc(ascOrDesc);
    }

    @Override
    public void checkBug(int oid) throws SQLException {
        ordersDao.buy(oid);
    }

    @Override
    public Collection<Product> showAllProductDesc() throws SQLException {
        return productDao.selectAllDesc();
    }


}
