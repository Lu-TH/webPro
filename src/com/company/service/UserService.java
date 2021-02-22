package com.company.service;

import com.company.entity.*;

import java.sql.SQLException;
import java.util.Collection;

/**
 * 用户业务接口
 */
public interface UserService {
    public void regist(User user)throws SQLException;//注册
    public String login(String uid) throws SQLException;//登录
    public Collection<OrdersAndOrderItemsAndProduct> showCart(String uid) throws SQLException;//查看购物车
    public void shop(Orders orders, Collection<OrderItems> orderItemsCollection) throws SQLException;//购买
    public Collection<Product> showProduct(String ptype) throws SQLException;//查看特定商品
    public User showUser(String uid) throws SQLException;//查看个人信息
    public Collection<OrdersAndOrderItemsAndProduct> showOrders(String uid) throws SQLException;//查看个人订单
    public void changeInfo(User user) throws SQLException;//修改个人信息 联系方式头像
    public Collection<Product> showAllProd(String ascOrDesc) throws SQLException;//查看所有商品 并按价格排序
    public void checkBug(int oid) throws SQLException;//确认购买
    public Collection<Product> showAllProductDesc() throws SQLException;
}
