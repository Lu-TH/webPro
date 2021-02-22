package com.company.dao;

import com.company.entity.OrdersAndOrderItemsAndProduct;

import java.sql.SQLException;
import java.util.Collection;

/**
 * 用户查看个人订单详情
 */
public interface OrdersAndOrderItemsAndProductDao {
    public Collection<OrdersAndOrderItemsAndProduct> showOrdersInfo(String uid) throws SQLException;//通过用户的uid查找 返回OrdersAndOrderItemsAndProduct对象
    public Collection<OrdersAndOrderItemsAndProduct> showArrearageOrder(String uid) throws SQLException;//显示用户的待付款订单
}
