package com.company.dao;

import com.company.entity.Orders;

import java.sql.SQLException;
import java.util.Collection;

/**
 * 增加订单
 * 删除
 * 查看订单状态
 * 查看用户订单
 */
public interface OrdersDao {
    public void insert(Orders orders) throws SQLException;//增加订单
    public void delete(int oid) throws SQLException;//删除订单 以订单编号删除
    public void update(int oid) throws SQLException;//取消订单
    public String selectState(int oid) throws SQLException;//查看订单状态
    public Collection<Orders> selectOrders(String fk_uid) throws SQLException;//查看用户订单
    public Orders selectAll(int oid) throws SQLException;//查看所有订单
    public void delByUid(String fk_uid) throws SQLException;//以用户为单位删除
    public void buy(int oid) throws SQLException;//付款  更改ostate
}
