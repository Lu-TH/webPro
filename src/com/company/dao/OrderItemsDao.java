package com.company.dao;

import com.company.entity.OrderItems;

import java.sql.SQLException;

/**
 * 修改订单
 */
public interface OrderItemsDao {
    public void insert(OrderItems orderItems) throws SQLException;//用户下单
    public void update(OrderItems orderItems) throws SQLException;//修改订单
    public void delete(String fk_oid) throws SQLException;//删除订单
    public void delByPid(String fk_pid) throws SQLException;//通过pid删除订单
}
