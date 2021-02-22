package com.company.dao;

import com.company.entity.User;

import java.sql.SQLException;
import java.util.Collection;

public interface OrdersAndOrderItemsAndUserDao {
    public Collection<User> selectUsers(String pid) throws SQLException;//查找购买指定商品的用户
}
