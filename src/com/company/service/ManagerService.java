package com.company.service;

import com.company.entity.*;

import java.sql.SQLException;
import java.util.Collection;

/**
 * 管理员业务接口
 */
public interface ManagerService {
    public void regist(Manager manager) throws SQLException;//注册管理员
    public String login(String mid) throws SQLException;//管理员登录
    public void addProduct(Product product) throws SQLException;//增加商品
    public void delProduct(String pid) throws SQLException;//删除商品 先删除order_items表中相关数据
    public void modProduct(Product product) throws SQLException;//更新商品
    public void modOrders(int oid) throws SQLException;//取消订单
    public Orders showOrders(int oid) throws SQLException;//查看订单
    public void modOrders(OrderItems orderItems) throws SQLException;//修改订单
    public String showState(int oid) throws SQLException;//订单状态
    public Collection<User> showUsers() throws SQLException;//查看用户
    public void delUser(String uid) throws SQLException;//删除用户 先删除orders表中相关数据
    public void modUser(User user) throws SQLException;//修改用户
    public Collection<Orders> showUserOrder(String uid) throws SQLException;//查看某用户的订单
    public Collection<User> showUserProduct(String pid) throws SQLException;//查看购买指定商品的用户
}
