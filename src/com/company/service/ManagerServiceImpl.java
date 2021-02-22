package com.company.service;

import com.company.dao.*;
import com.company.entity.*;

import java.sql.SQLException;
import java.util.Collection;

/**
 * 管理员业务实现
 */
public class ManagerServiceImpl implements ManagerService{
    ProductDao productDao = new ProductDaoImpl();
    OrdersDao ordersDao = new OrdersDaoImpl();
    OrderItemsDao orderItemsDao = new OrderItemsDaoImpl();
    UserDao userDao = new UserDaoImpl();
    OrdersAndOrderItemsAndUserDao ordersAndOrderItemsAndUserDao = new OrdersAndOrderItemsAndUserDaoImpl();
    ManagerDao managerDao = new ManagerDaoImpl();
    @Override
    public void regist(Manager manager) throws SQLException {
        managerDao.insert(manager);
    }

    @Override
    public String login(String mid) throws SQLException {
        return managerDao.selectPwd(mid);
    }

    @Override
    public void addProduct(Product product) throws SQLException {//增加商品
        productDao.insert(product);
    }

    @Override
    public void delProduct(String pid) throws SQLException {//删除商品 先删除order_items表中相关数据
        orderItemsDao.delByPid(pid);
        productDao.delete(pid);
    }

    @Override
    public void modProduct(Product product) throws SQLException {//更新商品
        productDao.update(product);
    }

    @Override
    public void modOrders(int oid) throws SQLException {//取消订单
        ordersDao.update(oid);
    }

    @Override
    public Orders showOrders(int oid) throws SQLException {//查看订单
        return ordersDao.selectAll(oid);
    }

    @Override
    public void modOrders(OrderItems orderItems) throws SQLException {//修改订单
        orderItemsDao.update(orderItems);
    }

    @Override
    public String showState(int oid) throws SQLException {//订单状态
        return ordersDao.selectState(oid);
    }

    @Override
    public Collection<User> showUsers() throws SQLException {//查看用户
        return userDao.selectAll();
    }

    @Override
    public void delUser(String uid) throws SQLException {//删除用户 先删除orders表中相关数据
        ordersDao.delByUid(uid);
        userDao.delete(uid);
    }

    @Override
    public void modUser(User user) throws SQLException {//修改用户
        userDao.update(user);
    }

    @Override
    public Collection<Orders> showUserOrder(String uid) throws SQLException {//查看用户订单
        return ordersDao.selectOrders(uid);
    }

    @Override
    public Collection<User> showUserProduct(String pid) throws SQLException {//查看购买指定商品的用户
        return ordersAndOrderItemsAndUserDao.selectUsers(pid);
    }
}
