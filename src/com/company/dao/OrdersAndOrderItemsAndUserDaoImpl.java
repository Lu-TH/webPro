package com.company.dao;

import com.company.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class OrdersAndOrderItemsAndUserDaoImpl implements OrdersAndOrderItemsAndUserDao{
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/supermarket";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static Connection connection;
    static{
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public Collection<User> selectUsers(String pid) throws SQLException {//查找购买指定商品的用户
        Collection<User> result = new ArrayList<>();
        String sql = " select uname, uphone from user where uid in (select fk_uid from orders where oid in (select fk_oid from order_items where fk_pid = ?)) ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, pid);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            String uname = rs.getNString("uname");
            String uphone = rs.getString("uphone");
            result.add(new User(uname, uphone));
        }
        return result;
    }
}
